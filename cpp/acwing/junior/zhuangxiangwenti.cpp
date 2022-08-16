//
// Created by rich heart on 16/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
using namespace std;
const int N = 40, V = 20010;
int v[N];
int f[N][V];
int main() {
    cin >> v >> n;
    for (int i = 1; i <= n; ++i) {
        int x;
        cin >> x;
        v[i] = x;
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= v; ++j) {
            f[i][j] = f[i - 1][j];
            if(j - v[i] >= 0) f[i][j] = max(f[i][j],f[i - 1][j - v[i]] + v[i]);
        }
    }
    cout << n - f[n][v] << endl;
    return 0;
}