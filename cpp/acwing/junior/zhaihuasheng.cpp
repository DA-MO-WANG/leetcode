//
// Created by rich heart on 01/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>
//思路：典型dp
//
using namespace std;
const int N = 110;
int t;
int f[N][N], c[N][N];
int main() {
    cin >> t;
    while (t--) {
        int r, c;
        cin >> r >> c;
        for (int i = 1; i <= r; ++i) {
            for (int j = 1; j <= c; ++j) {
                cin >> c[i][j];
            }
        }
        for (int i = 1; i <= r; ++i) {
            for (int j = 1; j <= c; ++j) {
                f[i][j] = max(f[i][j - 1],f[i - 1][j]) + c[i][j];
            }
        }
        cout << f[r][c] << endl;
    }
    return 0;
}