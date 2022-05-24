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
    q[++tt] = 1;
    while(hh <= tt) {
        int t = q[hh++];
        //枚举出边
        for (int i = h[t]; i != -1 ; i = ne[i]) {
            int j = e[i];
            d[j]--;
            //在它前面的边都跑过一遍——》此时才是放入队列的时机（维护队列的顺序）
            if(d[j] == 0) {
                q[++tt] = j;
            }
        }

    }
    return 
}

int n,m;
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
