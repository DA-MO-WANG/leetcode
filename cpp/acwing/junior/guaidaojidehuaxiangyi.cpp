//
// Created by rich heart on 05/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 110;
int k, n;
int v[N], f[2][N];
int main() {
    cin >> k;
    while(k--) {
        cin >> n;
        for (int i = 1; i <= n; ++i) {
            cin >> v[i];
        }

        for (int i = 1; i <= n; ++i) {
            if(i == 1) {
                f[0][i] = 1;
                continue;
            }
            for (int j = 1; j < i; ++j) {
                if(v[j] < v[i]) f[0][i] = max(f[0][i],f[0][j] + 1);
            }
        }

        for (int i = n; i >= 1; i--) {
            if(i == n) {
                f[1][i] = 1;
                continue;
            }
            for (int j = n; j > i; j--) {
                if(v[j] < v[i]) f[1][i] = max(f[1][i],f[1][j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 2; ++i) {
            for (int j = 1; j <= n; ++j) {
                res = max(res, f[i][j]);
            }
        }
        cout << res <<endl;

    }
    return 0;
}