//
// Created by rich heart on 07/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int f[N], v[N],g[N];
int main() {
    int count = 0;
    int x;
    while(cin >> x) {
        v[++count] = x;
    }
    for (int i = 1; i <= count; ++i) {
        f[i] = 1;
        for (int j = 1; j < i; ++j) {
            if(v[j] >= v[i]) f[i] = max(f[i],f[j] + 1);
        }
    }
    int res = 0;
    for (int i = 1; i <= count; ++i) {
        res = max(res, f[i]);
    }
    cout << res << endl;

    int cnt = 0;
    for (int i = 1; i <= count; ++i) {
        int k = 0;
        while(g[k] <= v[i]) k++;
        g[k] = v[i];
        if(k >= count) cnt++;
    }
    cout << cnt << endl;
    return 0;
}