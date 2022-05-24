//
// Created by rich heart on 5/24/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
const int N = 1e5 + 10;

//临接表构建图---图的边的存储结构
int h[N],e[N],ne[N],idx;

//bfs专用队列
int q[N];
//记录节点的入度
int d[N];
int n,m;
//在x节点处插入与y的边关系
void add(int x, int y) {
    e[idx] = y;
    ne[idx] = h[x];
    h[x] = idx++;
    //维护入度
    d[y]++;
}
int topsort() {
    memset(h,-1,sizeof h);

    int hh = 0, tt = -1;
    //突破口是所有入度为0的点 --队列的开始
    for(int i = 1; i <= n; i++) {
        if(d[i] == 0) {
            q[++tt] = i;
        }
    }
    while(hh <= tt) {

        int t = q[hh++];
        //枚举出边
        for (int i = h[t]; i != -1 ; i = ne[i]) {
            int j = e[i];
            //删除t->j 这个边
            d[j]--;
            //在它前面的边都跑过一遍——》此时才是放入队列的时机（维护队列的顺序）
            if(d[j] == 0) {
                q[++tt] = j;
            }
        }

    }
    //实际维护的队列元素数量（出队不影响元素数量，只是移动的是指针）
    //队列最终维护是入度为0的点，也就是无环图最终都会被突破成入度为0
    return tt == n - 1;
}


int main() {
    cin >> n >> m;
    while(m--) {
        int x, y;
        cin >> x >> y;
        add(x,y);
    }

    if(topsort()) {
        puts("%d",)
    }


}
