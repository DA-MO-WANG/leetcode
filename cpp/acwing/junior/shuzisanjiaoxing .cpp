//
// Created by rich heart on 18/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
//设置一个特别小的数==》特别大的数取反
const int N = 510, INF = 1e9;
int n;
int f[N][N];
int v[N][N];
int main() {
    cin >> n;
    for (int i = 1; i <= n ; ++i) {
        for (int j = 1; j <= i; ++j) {
            cin >> v[i][j];
        }
    }
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= n; ++j) {
            f[i][j] = -INF;
        }
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            //考虑边界的情况，不通的路径不应视为0，考虑到全负数的数据
            //不通的情况，因为求最大值，所以应该视为特别小==》需要为这个结构初始化，全部特别小，无论边界内还是边界外
            f[i][j] = max(f[i - 1][j - 1] + v[i][j], f[i - 1][j] + v[i][j]);
        }
    }
    int res = -INF;
    //题的意思是到底层的最大值==》还要遍历最后一层
    for (int j = 1; j <= n; ++j) {
        res = max(res,f[n][j]);
    }
    cout << f[n][m] << endl;
    return 0;
}