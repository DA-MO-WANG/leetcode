//
// Created by rich heart on 07/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
typedef pair<int,int> PII;
const int N = 5010;
PII pii[N];
int f[N],g[N];
int n;
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        int s, n;
        cin >> s >> n;
        pii[i] = {s,n};
    }
    sort(pii + 1, pii + n + 1);
    for (int i = 1; i <= n; ++i) {
        f[i] = 1;
        for (int j = 1; j < i; ++j) {
            int si = pii[i].second, sj = pii[j].second;
            if(si > sj) f[i] = max(f[i],f[j] + 1);
        }
    }
    for (int i = n; i; i--) {
        g[i] = 1;
        for (int j = n; j > i; j--) {
            int si = pii[i].second, sj = pii[j].second;
            if(si < sj) f[i] = max(g[i],g[j] + 1);
        }
    }
    int res = 0;
    for (int i = 1; i <= n; ++i) {
        res = max(f[i],g[i]);
    }
    cout << res << endl;
    return 0;
}