//
// Created by rich heart on 5/31/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
//prim
const int N = 510, M = 1e5 + 10, INF = 0x3f3f3f3f;
int dis[N];//这个东西发生了变化，以前是点到点，现在是点到集合的距离
//边特别多——》稠密图——》邻接矩阵
int g[N][N];
int n, m;
bool str[N];
int prim() {
    //初始状态下，各个点到集合的距离是无穷，不连通
    memset(dis,0x3f,sizeof dis);
    int res = 0;
    for(int i = 0; i < n; i++) {
        //每一个点都过一遍集合
        int t = -1;//集合外的点到
        //选出一个加入集合的点
        for(int j = 1; j <= n; j++) {
            if(!str[j] && (t == -1 || dis[t] > dis[j])) t = j;
        }
        //第一次，走完j，t是1
        str[t] = true;
        //if(t == 1) dis[t] = 0;===》1种写法

        //利用第一次，每个点上的INF会有机会被替换掉
        if(i && dis[t] == INF) return INF;
        //运用上面的for循环的作用，选出的最短距离，来预判一种可以提前结束的特殊情况
        //如果最短距离都=INF，没被替换掉，说明后面这些点根本不连通，也就是整个无向图中，存在分裂的部分
        //这种情况下，是没有最小生成树的
        if(i) res += dis[t];




        //res统计的是集合内边的长度和


        //用这个点更新一下其他点到集合的距离
        for(int k = 1; k <= n; k++) {
            if(!str[k]) dis[k] = min(dis[k],g[t][k]);
        }
    }
    return res;
}
int main() {
    scanf("%d%d",&n,&m);
    while(m--) {
        int u, v, w;
        scanf("%d%d%d",&u,&v,&w);
        //无向图
        //重边
        //自环
        g[u][v] = g[v][u] = min(g[u][v],w);

    }
    int res = prim();
    if(res == INF) cout << "impossible";
    else cout << res;







}
