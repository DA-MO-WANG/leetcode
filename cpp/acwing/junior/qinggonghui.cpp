//
// Created by rich heart on 19/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 6010;
int f[N];
int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        int v, w ,s;
        cin >> v >> w >> s;
        for (int j = m; j >= v ; j--) {
            for (int k = 0; k <= s; ++k) {
                f[j] = max(f[j],f[j - k * v] + k * w);
            }
        }
    }
    cout << f[m];
    return 0;
}