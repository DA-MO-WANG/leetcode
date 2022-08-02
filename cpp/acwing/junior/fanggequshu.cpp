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
    for (int k = 1; k <= 2 * N; k++) {
        for (int i = 0; i < ; ++i) {
            
        }
    }
    int res = f[n][n];
    dp();
    res += f[n][n];
    cout << res << endl;
    return 0;
}