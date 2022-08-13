//
// Created by rich heart on 13/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 3010;
int n;
int a[N],b[N];
int f[N][N];
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    for (int j = 1; j <= n; ++j) {
        cin >> b[i];
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            f[i][j] = f[i - 1][j];
            if(a[i] == b[j]) {
                f[i][j] = max(f[i][j],f[i][1]);
                for (int k = 1; k < j; ++k) {
                    if(b[k] < b[j]) f[i][j] = max(f[i][j],f[i][k] + 1);
                }
            }
        }
    }
    int res = 0;
    for (int i = 1; i <= n; ++i) {
        res = max(f[n][i],res);
    }
    cout << res << endl;
    return 0;
}