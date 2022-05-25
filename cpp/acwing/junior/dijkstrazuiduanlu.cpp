//
// Created by rich heart on 5/25/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
//1个点到1个点的最短距离——》单源最短路
// 边权为正——》dijkstra算法
//n与m的关系，重m——》稠密图——》朴素dijkstra

//稠密图——》用邻接矩阵存储边关系
const int M = 1e5 + 10, N = 510;
int g[N][N];
int n, m;
int dis[N];//维护的是与起点的距离
bool str[N];//维护的是每个点是否已经确定了最短路情况
//重边——》为了不影响最短路，只保存最短的边权
//自环不影响最短路的计算
void add(int x, int y, int z) {
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            g[x][y] = min(g[x][y],z);
        }
    }
}
int dijkstra() {
    str[1] = true;
    for (int i = 1; i <= n ; ++i) {
        int t = -1;//代表最有可能确定最短距离的点，用t来保存--这里是选择排序
        //从还没确定中的集合中去找
        for (int j = 1; j <= n ; ++j) {
            if(!str[j] && t == -1 | dis[t] > dis[j]) {
                t = j;
            }
        }
        str[t] = true;
        if(t == n) break;
    }
    //上面完成了每个点的最短距离
    if(dis[n] == 0x3f3f3f3f) return  -1;
    else return dis[n];
}
int main() {
    cin >> n >> m;
    while(m--) {
        int x, y , z;
        cin >> x >> y >> z;
        add(x,y,z);
    }
    memset(dis,0x3f,sizeof dis);//初始设每个点到起点距离无穷大
    dis[1] = 0;//设置1为起点，起点到自己的间距为0
    int res = dijkstra();
    cout << res;


}
