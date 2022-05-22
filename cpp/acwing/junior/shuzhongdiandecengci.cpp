//
// Created by rich heart on 5/22/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
//bsf框架打出来:当第一次找到这个点时，就是找到最短距离的时候
//有向图结构
int h[N],e[N],ne[N],idx;
int n,m;
int d[N];
int q[N],hh = 0, tt = 0;
void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}

//bfs 和dfs的不同的是，没有递归参数，因为它是用队列维护的，
//这个是否访问过，也不像dfs一样用单独的标识数组显示，而是用距离数组维护的
void bfs() {
    //队列中至少有一个点
    q[0] = 1;
    while(hh <= tt) {
        //拿到队头的点--一层层扩展，队列中元素是按层排布的
        int t = q[hh++];//h[t]是单链表上的头节点;t是节点编号

        //顺着当前节点的关系往下走
        //队列之所以能一直往下走下去，是在踢人的同时又把他的儿子招进来，直到这个人没有后代为止，整个过程结束
        for (int i = h[t]; i != -1; i = ne[i]) {
           if(d[e[i]] == -1) {
               d[e[i]] = d[t] + 1;
               q[++tt] = e[i];
               //更新d[n]
           }
        }
    }
}
int main() {

    cin >>n >>m;
    memset(h,-1,sizeof h);
    memset(d,-1,sizeof d);//默认没有涉及到，就不会被覆盖，值就是-1
    d[1] = 0;//第一个点对应的到节点的距离是0，不破坏流程计算逻辑
    while (m--) {
        int a, b;
        cin >> a >> b;
        add(a,b);
    }
    bfs();
    cout << d[n];


}
