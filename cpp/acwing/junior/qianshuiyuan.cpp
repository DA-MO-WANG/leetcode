//
// Created by rich heart on 17/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 110, k = 1010;
int f[k][N][N];
int o[k],d[k],w[k];
int main() {
    int m, n, k;
    cin >> m >> n >> k;
    for (int i = 1; i <= k; ++i) {
        cin >> o[i] >> d[i] >> w[i];
        for (int j = 0; j <= m; ++j) {
            for (int l = 0; l <= n; ++l) {
                f[i][j][k] = f[i - 1][j][k];
                if(j >= o[i] && l >= d[i]) {
                    f[i][j][k] = min(f[i][j][k],f[i - 1][j - o[i]][l - d[i]] + w[i]);
                }
            }
        }
    }
    cout << f[k][m][n];
    return 0;
}