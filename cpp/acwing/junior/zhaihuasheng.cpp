//
// Created by rich heart on 01/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>
//思路：典型dp
//每一步，有两种走法，问什么样的走法，花生数量最多---带权路径和最大
//每一步问题，拆解成可重复的结构：状态转移，从而不断降级，一致转移到dp基状态
//状态的传递具有有限性，确定性，所以必然能通向最终结果
using namespace std;
const int N = 110;
int t;
int f[N], w[N][N];
int main() {
    cin >> t;
    while (t--) {
        int r, c;
        cin >> r >> c;
        for (int i = 1; i <= r; ++i) {
            for (int j = 1; j <= c; ++j) {
                cin >> w[i][j];
            }
        }
        for (int i = 1; i <= r; ++i) {
            for (int j = 1; j <= c; ++j) {
                f[j] = max(f[j - 1],f[j]) + w[i][j];
            }
        }
        cout << f[c] << endl;
    }
    return 0;

    //优化成一维数组
    //这种依赖于相邻状态的大多可以借助记忆留存效果，优化成一维
}