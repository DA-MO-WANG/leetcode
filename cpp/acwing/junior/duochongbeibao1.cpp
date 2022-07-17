//
// Created by rich heart on 17/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
const int N = 110;
int v[N],w[N],s[N];
int f[N][N];
int n, m;
int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        cin >> v[i] >> w[i] >> s[i];
    }
    for (int i = 1; i <= n ; ++i) {
        for (int j = 0; j <= m ; ++j) {
            for (int k = 0; k <= s[i] && k * v[i] <= j; ++k) {
                //k = 0 就是选0个的情况
                //max你得保留一个自身，用来更新，进而反复比较
                //易错点：这几个公式容易混淆，所以说要明白写的每一个式子都在说什么
                f[i][j] = max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
            }
        }
    }
    cout << f[n][m] << endl;
    return 0;
}