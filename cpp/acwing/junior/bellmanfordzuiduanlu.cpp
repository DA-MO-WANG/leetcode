//
// Created by rich heart on 5/27/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
//最短路问题，有边权，而且负权，k边限制——》bellman-ford 算法

//bellman-ford算法边构造
const int N = 510, M = 1e4 + 10;
//用结构体保存这个边
struct edge {
    int x, y, z;
}edge[M];
int n, m, k;
int dis[N];
int backup[N];
int bellman_ford() {
    memset(dis,0x3f,sizeof dis);
    dis[1] = 0;

    for (int i = 0; i < k; ++i) {
        memcpy(backup,dis,sizeof dis);
        for (int j = 0; j < m; ++j) {

            int x = edge[j].x;
            int y = edge[j].y;
            int z = edge[j].z;
            if(dis[y] > backup[x] + z) {
                dis[y] = backup[x] + z;
            }
        }
    }

    if(dis[n] > 0x3f3f3f3f / 2) return -1;
    else return dis[n];
}

int main() {
    cin >> n >> m >> k;
    for (int i = 0; i < m; ++i) {
        int x, y ,z;
        cin >> x >> y >> z;
        edge[i] = {x,y,z};
    };
    int res = bellman_ford();
    cout << res;
}
