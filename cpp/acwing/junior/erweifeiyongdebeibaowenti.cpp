//
// Created by rich heart on 10/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010, M = 110;
//状态定义：前i个物品中，不大于j体积，m重量的所有选法
int f[N][M][M];
int n,v,m;
int main() {
    cin >> n >> v >> m;
    for (int i = 1; i <= n; ++i) {
        int v1,m1,w1;
        cin >> v1 >> m1 >> w1;
        for (int j = 1; j <= v; ++j) {
            for (int k = 1; k <= m; ++k) {
                f[i][j][k] = f[i - 1][j][k];
                if(j >= v1 && k >= m1) f[i][j][k] = max(f[i][j][k],f[i - 1][j - v1][k - m1] + w1);
            }
        }
    }
    cout << f[n][v][m];
    return 0;
}