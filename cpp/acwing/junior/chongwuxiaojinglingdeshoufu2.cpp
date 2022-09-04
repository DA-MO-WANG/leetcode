//
// Created by rich heart on 04/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
/**
 * 双重限制因素的01背包
 */
using namespace std;
const int N = 1010, M = 510;
//精灵球数量-体力 充当体积的限制作用
//精灵的数量充当价值
//f(n,m) 消耗n个精灵球，m个体力，捕获的精灵的数量的各种可能
int f[N][M];
int main() {
    int n, m ,k;
    cin >> n >> m >> k;
    for (int i = 0; i < k; ++i) {
        int v1, v2;
        cin >> v1 >> v2;
        for (int j = n; j >= v1 ; j--) {
            for (int l = m; l >= v2 ; l--) {
                f[j][l] = max(f[j][l], f[j - v1][l - v2] + 1);
            }
        }
    }
    //至少剩余1格体力
    cout << f[n][m - 1] << " ";
    int k = m;
    //每次比较的是下一个，下一个满足相等才减一
    while(k > 0 && f[n][m - 1] == f[n][k - 1]) k--;
    //输出的是最大剩余体力，同等数量下最小消耗
    cout << m - k <<;
    return 0;
}