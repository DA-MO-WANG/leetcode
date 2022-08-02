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
                int j1 = k - i1, j2 = k - i2;
                if(j1 >=1 && j1 <= n && j2 >= 1 && j2 <= n) {
                    int t = &w[i1][j1];
                    if(i1 != i2) t += w[i2][j2];
                    t = max(t,f[k - 1][i1 - 1][i2 - 1] + t);
                    t = max(t,f[k - 1][i1 - 1][i2] + t);
                    t = max(t,f[k - 1][i1][i2 - 1] + t);
                    t = max(t,f[k - 1][i1][i2] + t);
                }

            }

        }
    }
    cout << f[2 * n][n][n] << endl;
    return 0;
}