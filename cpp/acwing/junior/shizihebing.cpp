//
// Created by rich heart on 21/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 310;
int n;
//状态表示：区间[i,j]内的所有合并方式
//集合关注：所有合并情况的最小代价min
int f[N][N];
int s[N];
int main() {
    cin >> n;
    //这里从1开始方便计算前缀和 s[i - 1]
    for (int i = 0; i < n; ++i) scanf("%d",s[i]);
    //计算前缀和
    for (int i = 1; i < n; ++i) s[i] += s[i - 1];
    //dp


    //第一层循环是枚举区间长度
    for (int len = 2; len < n; ++len) {
        //蝶儿层循环是枚举区间端点
        for (int i = 1; i < n; ++i) {
            //明确要处理的区间端点情况
            int l = i, r = i + len - 1;
            //边界问题--初始值情况（后面要和初始值比较）
            f[l][r] = 1e8;
            //枚举分类点的情况
            for (int k = 1; k < len; ++k) {
                f[l][r] = min(f[l][k],f[k + 1][r]) + s[r] - s[l - 1];
            }

        }
    }
    cout << f[1][n] << endl;

    return 0;
}