//
// Created by rich heart on 16/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
const int N = 1010;
int v[N], w[N];
int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        cin >> v[i] >> w[i];
    }

    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
            f[i][j] = f[i - 1][j];
            int k = 0;
            while(j >= k * v[i]) {
                f[i][j] = max(f[i][j],f[i - 1][j - k * v[i]] + k * w[i]);
                k++;
            }
        }
    }
    cout << f[n][m];
    return 0;
}