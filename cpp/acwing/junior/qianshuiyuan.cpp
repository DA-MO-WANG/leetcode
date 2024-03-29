//
// Created by rich heart on 17/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 110, k = 1010;
int f[N][N];
int o[k],d[k],w[k];
int main() {
    int m, n, k;
    cin >> m >> n >> k;
    f[0][0] = 0;
    memset(f,0x3f, sizeof(f));
    for (int i = 1; i <= k; ++i) {
        cin >> o[i] >> d[i] >> w[i];
        for (int j = m; j >= 0; j--) {
            for (int l = n; l >= 0; l--) {
                f[j][l] = min(f[j][l],f[max(0,j - o[i])][max(0,l - d[i])] + w[i]);
            }
        }
    }
    cout << f[m][n];
    return 0;
}