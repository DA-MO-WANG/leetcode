//
// Created by rich heart on 5/28/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
const int N = 210, INF = 0x3f3f3f3f;
int n,m,q;
int dis[N][N];//存储任意两点的最短距离
int main() {
    scanf("%d%d%d",&n,&m,&q);
    for (int i = 1; i <= n ; ++i) {
        for (int j = 1; j <= n ; ++j) {
            //初始化，任意两点都不相通--很大的数
            if(i == j) dis[i][j] = 0;
            else dis[i][j] = INF;

        }

    }

    while(m--) {
        int x, y ,z;
        cin >> x >> y >> z;
        //重边，自环
        if(x == y) dis[x][y] = 0;
        else dis[x][y] = min(dis[x][y],z);
    }

    //floyd主体框架
    for(int k = 1; k <= n; k++) {
        for (int i = 1; i <= n ; ++i) {
            for (int j = 1; j <= n ; ++j) {
                dis[i][j] = min(dis[i][j],dis[i][k] + dis[k][j])
            }
        }
    }

    while(q--) {
        int x, y;
        cin >> x >> y;
        if(dis[x][y] >= 0x3f3f3f3f / 2) cout << "impossible";
        else cout << dis[x][y];
    }


}
