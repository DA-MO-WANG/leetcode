//
// Created by rich heart on 01/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
const int N = 110;
int n;
int f[N][N], e[N][N];
int dx[4] = {-1,1,0,0}, dy[4] = {0,0,-1,1};
int dfs(int x, int y, int count) {
    if(!x || !y) {
        return 0;
    }

    for (int i = 0; i < 4; ++i) {
        int row = x + dx[i], col = y + dy[i];
        if(row && row <= n && col && col <= n && count <= 2 * n - 1) {

            f[x][y] = min(dfs(row,col,++count),f[x][y]) + e[x][y];
        }
    }
    return f[x][y];
}
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            cin >> e[i][j];
        }
    }
    memset(f,0x3f, sizeof(f));
    int count = 0;
    cout << f[n][n] << endl;

    return 0;
}