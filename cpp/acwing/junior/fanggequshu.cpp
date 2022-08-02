//
// Created by rich heart on 02/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 15;
int n;
//f(k,i1,i2)
//
int f[N * 2][N][N], w[N][N];
int main() {
    cin >> n;
    int row , col, v;
    
    //这是一种写法技巧
    while (cin >> row >> col >> v, row || col || v) {
        w[row][col] = v;
    }

    for (int k = 1; k < 2 * n; k++) {
        for (int i1 = 1; i1 <= n; ++i1) {
            for (int i2 = 0; i2 <= n; ++i2) {
                int t = &f[k][i1][i2];
                if(i1 != i2) t += w[i1][k - i1];
                t = max(t,f[k - 1][i1 - 1][i2 - 1] + w[i2][k - i2]);
                t = max(t,f[k - 1][i1 - 1][i2] + w[i2][k - i2]);
                t = max(t,f[k - 1][i1][i2 - 1] + w[i2][k - i2]);
                t = max(t,f[k - 1][i1][i2] + w[i2][k - i2]);
            }

        }
    }
    cout << f[2 * n - 1][n][n] << endl;
    return 0;
}