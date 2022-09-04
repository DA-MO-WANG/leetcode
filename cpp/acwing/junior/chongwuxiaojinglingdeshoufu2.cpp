//
// Created by rich heart on 04/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010, M = 510;
int f[N][M];
int main() {
    int n, m ,k;
    cin >> n >> m >> k;
    for (int i = 0; i < k; ++i) {
        int v1, v2;
        cin >> v1 >> v2;
        for (int j = n; j >= v1 ; j--) {
            for (int l = m; l > v2 ; l--) {
                f[j][l] = max(f[j][l], f[j - v1][l - v2] + 1);
            }
        }
    }
    cout << f[n][m] << " ";
    int k = m;
    while(k > 0 && f[n][m] == f[n][k - 1]) k--;
    cout << m - k <<;
    return 0;
}