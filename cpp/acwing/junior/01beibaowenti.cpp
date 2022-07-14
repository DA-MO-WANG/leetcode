//
// Created by rich heart on 13/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
const int N = 1010;
//记录体积情况、权重情况
int v[N],w[N];
//记录状态
//int f[N][N];

//滚动数组优化
int f[N];
int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        cin >> v[i] >> w[i];
    }
    for (int i = 1; i <= n; ++i) {
        //从大到小，是为了记忆留存的效果不被i时的j - v[i] 替换掉
        for (int j = m; j >= v[i]; j--) {
            //f[i][j] = f[i - 1][j];
            f[j] = max(f[j],f[j - v[i]] + w[i]);
        }
    }
    cout << [m];

    return 0;
}