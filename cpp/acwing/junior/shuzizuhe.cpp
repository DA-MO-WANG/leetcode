//
// Created by rich heart on 18/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 110, M = 10010;
int f[N][M];
int main() {
    int n,m;
    cin >> n >> m;
    for (int i = 0; i <= n; ++i) {
        f[i][0] = 1;
    }
    for (int i = 1; i <= n; ++i) {
        int v;
        cin >> v;
        for (int j = m; j >= v ; j--) {
            f[i][j] = f[i - 1][j];
            f[i][j] += f[i - 1][j - v];
        }
    }
    cout << f[n][m];
    return 0;
}