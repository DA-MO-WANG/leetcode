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
bool str[N];
void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}
void bfs(int u) {
    str[u] = true;
    q[0] = 1;
    while(hh <= tt) {
        //拿到队头的点--一层层扩展，队列中元素是按层排布的
        int t = q[hh++];//h[t]是单链表上的头节点;t是节点编号

        //顺着当前节点的关系往下走
        for (int i = h[t]; i != -1; i = ne[i]) {
           if(!str[e[i]]) {
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
    memset()
    while (m--) {
        int a, b;
        cin >> a >> b;
        add(a,b);
    }
    bfs(1);
    cout << d[n];


}
