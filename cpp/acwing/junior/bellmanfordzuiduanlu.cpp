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
int bellman_ford() {
    for (int i = 0; i < k; ++i) {
        for (int j = 0; j < m; ++j) {

        }
    }
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
