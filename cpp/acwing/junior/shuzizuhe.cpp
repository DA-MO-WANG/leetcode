//
// Created by rich heart on 18/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 110, M = 10010;
int f[M];
int main() {
    int n,m;
    cin >> n >> m;
    f[0] = 1;
    for (int i = 1; i <= n; ++i) {
        int v;
        cin >> v;
        //学的太死板了
        //不是出现i- 1 就从大到小，而是优化成1维的时候才从大到小
        for (int j = m; j >= v ; j--) {
            f[j] += f[j - v];
        }
    }
    cout << f[m];
    return 0;
}