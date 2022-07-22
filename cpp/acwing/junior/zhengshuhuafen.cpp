//
// Created by rich heart on 22/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int n;
int f[N][N];
int main() {
    cin >> n;
    f[1][1] = 1;
    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            for (int k = 0; k * i <= j; ++k) {
                f[i][j] += f[i - 1][j - k * i];
            }
        }
    }
    cout << f[n][n];
    return 0;
}