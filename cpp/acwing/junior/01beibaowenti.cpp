//
// Created by rich heart on 13/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
//记录体积情况、权重情况
int v[N],w[N];
//记录状态
int f[N][N];
int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        scanf("%d%d",v[i],w[i]);
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
            if(j > v[i]) f[i][j] = f[i - 1][j] + f[i - 1][j - v[i]] + w[i];
        }
    }
    cout << f[n][m];

    return 0;
}