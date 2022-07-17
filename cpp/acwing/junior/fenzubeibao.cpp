//
// Created by rich heart on 17/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int n, m;
const int N = 110;
int v[N][N],w[N][N];
int f[N][N];
int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        int s;
        cin >> s;
        for (int j = 1; j <= s; ++j) {
            cin >> v[i][j] >> w[i][j];
        }
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= m ; ++j) {
            f[i][j] = f[i - 1][j];
            for (int k = 1; v[i][k]; ++k) {
                f[i][j] = max(f[i][j],f[i - 1][j - v[i][k]] + w[i][k]);
            }
        }
    }
    cout << f[n][m] <<endl;
    return 0;
}