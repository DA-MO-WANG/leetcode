//
// Created by rich heart on 01/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 110;
int n;
int f[N][N], e[N][N];
int dx[4] = {-1,1,0,0}, dy[4] = {0,0,-1,1};
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            cin >> e[i][j];
        }
    }
    memset(f,0x3f, sizeof(f));
    int count = 0;
    for (int x = 1; x <= n; ++x) {
        for (int y = 1; y <= n; ++y) {
            for (int i = 0; i < 4; ++i) {
                int row = x + dx[i], col = y + dy[i];
                if(row && row <= n && col && col <= n && count <= 2 * n - 1) {
                    f[x][y] = min(f[row][col],f[x][y]) + e[x][y];
                }
            }
            count ++;

        }
    }
    cout << f[n][n] << endl;

    return 0;
}