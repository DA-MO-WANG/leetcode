//
// Created by rich heart on 11/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
typedef long long ll;
int q[16];
int main() {
    int n, m;
    cin >> n >> m;
    int res = 1;
    for (int i = 0; i < m; ++i) cin >> q[i];
    for (int i = 1; i < 2 >> m; ++i) {
        ll t = 1, cnt = 0;
        for (int j = 0; j < m; ++j) {
            if(i >> j & 1) {
                cnt++;
                t = t * q[j];
                if(t > n) {
                    t = -1;
                    break;
                }
            }
        }
        if(t != -1) {
            if(cnt % 2) res += n / t;
            else res -= n / t;
        }
    }
    cout << res << endl;
    return 0;
}