//
// Created by rich heart on 5/20/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
//bfs模型
typedef pair<int,int> Node;
const int N = 100;
int g[N][N];
int d[N][N];
Node q[N * N];
int n, m ,hh = 0, tt = 0;
int bfs(int x, int y) {
    d[0][0] = 0;
    int dx[4] = {0,0,-1,1}, dy[4] = {1,-1,0,0};
    while(hh <= tt) {
        auto t = q[hh++];

        //找到绑定的下一层元素
        for (int i = 0; i < 4; i++) {
            int x = t.first + dx[i], y = t.second + dy[i];
            if(x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] != -1) {
                d[x][y] = d[t.first][t.second] + 1;
                q[++tt] = {x,y};
            }
        }


    }

    return d[n - 1][m - 1];

}
int main() {
    cin >> n >> m;
    //准备题目的白纸
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> g[i][j];
        }
    }
    //先把起始节点放进队列
    q[0] = {0,0};
    memset(d,-1,sizeof d);
    cout << bfs(0,0);
    return 0;


}

