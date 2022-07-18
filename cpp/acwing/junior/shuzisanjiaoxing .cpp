//
// Created by rich heart on 18/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
const int N = 510;
int n;
int f[N][N];
int v[N][N];
int main() {
    cin >> n;
    for (int i = 1; i <= n ; ++i) {
        for (int j = 1; j <= i; ++j) {
            cin >> v[i][i];
        }
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            f[i][j] = max(f[i - 1][j - 1] + v[i][j], f[i - 1][j] + v[i][j]);
        }
    }
    cout << f[n][m] << endl;
    return 0;
}