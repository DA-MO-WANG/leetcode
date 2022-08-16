//
// Created by rich heart on 16/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
const int T = 1010, M = 110;
int t[M],w[M];
int f[T][M];
int main() {
    int times,nums;
    cin >> times >> nums;
    for (int i = 1; i <= nums; ++i) {
        int x, y;
        t[i] = x, w[i] = y;
    }
    for (int i = 1; i <= times; ++i) {
        for (int j = 1; j <= nums; ++j) {
            if(j - w[i] > 0) f[i][j] = max(f[i - 1][j],f[i - 1][j - w[i]] + w[i]);
        }
    }
    cout << f[times][nums] << endl;
    return 0;
}