//
// Created by rich heart on 05/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int v[N],f[N],g[N];
int n;
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> v[i];
    }
    for (int i = 1; i <= n; ++i) {
        f[i] = 1;
        for (int k = 1; k < i; ++k) {
            if(v[k] < v[i]) f[i] = max(f[i],f[k] + 1);

        }
    }
    for (int i = n ; i; i--) {
        g[i] = 1;
        for (int k = n; k > i; k--) {
            if(v[k] < v[i]) g[i] = max(g[i],g[k] + 1);

        }
    }
    int res = 0;
    //枚举拐点
    for (int i = 1; i <= n; ++i) {
        res = max(f[i] + g[i] - 1,res);
    }
    cout << n - res << endl;
    return 0;
}