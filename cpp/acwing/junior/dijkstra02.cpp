//
// Created by rich heart on 5/30/22.
//

#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 510, M = 10010,INF = 0x3f3f3f3f;
//单源
//正权
//有向图
//稠密图——》邻接矩阵，来表示边
int n,m;
int g[N][N];
int dis[N];
bool str[N];
int dijkstra() {
    memset(dis,0x3f,sizeof dis);
    dis[1] = 0;
    //循环n次，每次确定一个最短距离的节点
    for (int i = 1; i <= n; ++i) {
        int t = -1;//类似选择排序的思路，先假设一个最短距离
        //选出到起点最短距离的点
        int j = i + 1;
        //用假设的最短距离点和其他没确定最短距离的点都比较一遍，
        while(t && (t == -1 || dis[t] > dis[++j])) t = j;


    }

    if(dis[n] == INF) return -1;
    else return dis[n];
}
int main() {
    scanf("%d%d",&n,&m);
    while (m--) {
        int x, y , z;
        scanf("%d%d%d",&x,&y,&z);

        //重边
        //自环——》在正权图中不用管
        g[x][y] = min(g[x][y],z);
    }
    int res = dijkstra();
    if(res == -1) printf("-1");
    else printf("%d",dis[n]);









}
