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
    if(x == y) g[x][y] = 0;
    else g[x][y] = min(g[x][y],z);
}
int dijkstra() {
    //最外层循环：迭代n次，每一次都会确定一个点的最短距离，最终确定下来
    for (int i = 1; i <= n ; ++i) {
        //从还没有确定最短距离的集合中找到一个最小的距离的点
        int t = -1;//代表还没有找到

        //取遍历所有节点，找到最小的距离
        for (int j = 1; j <= n ; ++j) {
            //str维护的是否在前面被确定了
            if(!str[j] && (t == -1 || dis[t] > dis[j])) {
                t = j;
            }
        }
        //把找到最小距离的点加入到确定的集合中
        str[t] =   true;
        if(t == n) break;

        //拿t来更新其他点的距离
        for(int i = 1; i <= n; i++) {
            if(!str[i]) dis[i] = min(dis[i],dis[t] + g[t][i]);
        }
    }
    //上面完成了每个点的最短距离
    if(dis[n] == 0x3f3f3f) return  -1;
    else return dis[n];
}
int main() {
    cin >> n >> m;
    //每条边的权重默认为一个很大的值，方便重边保留最小值的实现。只有一开始最大(比所有权重都大)，min才能不断取设定的值
    memset(g, 0x3f, sizeof g);
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
