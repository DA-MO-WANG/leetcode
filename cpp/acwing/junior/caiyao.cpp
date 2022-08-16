//
// Created by rich heart on 16/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
const int T = 1010, M = 110;
//t用来存储每个物品的时间情况
//w用来存储每个物品的价值情况
int t[M],w[M];
//f(i,j) 代表前i个物品中，不超过j时间内的所有选法的情况
int f[T];
int main() {
    int times,nums;
    cin >> times >> nums;
    for (int i = 1; i <= nums; ++i) {
        int x, y;
        cin >> x >> y;
        t[i] = x, w[i] = y;
    }
    for (int i = 1; i <= nums; ++i) {
        for (int j = times; j >= t[i]; ++j) {
            //集合划分：第i个物品选法中一定不存在
            //第i个物品选法中一定存在
            f[j] = max(f[j],f[j - t[i]] + w[i]);
        }
    }
    cout << f[times] << endl;
    return 0;
}