//
// Created by rich heart on 03/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int f[N],g[N],q[N];
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        int v, w, s;
        cin >> v >> w >> s;
        memcpy(g, f, sizeof(f));
        for (int j = 0; j < v; ++j) {
            int hh = 0, tt = -1;
            for (int k = j; k <= m; ++k) {
                if(hh <= tt && q[hh] < k - s * v) hh++;
                if(hh <= tt) f[k] = max(f[k],g[q[hh]] + (k - q[hh]) / v * w)
                while(hh <= tt && g[q[tt]] - (k - q[tt]) / v * w <= g[k])
            }
        }
    }
    return 0;
}