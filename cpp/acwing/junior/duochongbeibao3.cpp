//
// Created by rich heart on 03/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
//复制粘贴-暂时没搞懂，跃过
using namespace std;
const int N = 20010;
int f[N],g[N],q[N];
int n, m;
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        int v, w, s;
        cin >> v >> w >> s;
        memcpy(g, f, sizeof(f));
        for (int j = 0; j < v; ++j) {
            int hh = 0, tt = -1;
            for (int k = j; k <= m; k += v) {
                if(hh <= tt && q[hh] < k - s * v) hh++;
                if(hh <= tt) f[k] = max(f[k],g[q[hh]] + (k - q[hh]) / v * w);
                while(hh <= tt && g[q[tt]] - (q[tt] - j) / v * w <= g[k] - (k - j) / v * w) tt--;
                q[++tt] = k;
            }
        }
    }
    cout << f[m] << endl;
    return 0;
}