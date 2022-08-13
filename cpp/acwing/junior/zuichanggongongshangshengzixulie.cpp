//
// Created by rich heart on 13/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 3010;
int n;
int a[N],b[N];
//在前i个元素中出现，又在前j个元素中出现，同时以b[j]结尾的公共上升子序列
int f[N][N];
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    for (int j = 1; j <= n; ++j) {
        cin >> b[j];
    }
//    for (int i = 1; i <= n; ++i) {
//        for (int j = 1; j <= n; ++j) {
//            //a[i]一定不在公共上升子序列中
//            f[i][j] = f[i - 1][j];
//            //a[i]一定在公共上升子序列中
//            if(a[i] == b[j]) {
//                //第二层的划分：最初始是倒数第二个元素为空，此时公共上升子序列为1
//                f[i][j] = max(f[i][j],1);
//                for (int k = 1; k < j; ++k) {
//                    if(b[k] < b[j]) f[i][j] = max(f[i][j],f[i][k] + 1);
//                }
//            }
//        }
//    }

    //优化版本一：剪掉一维
    for (int i = 1; i <= n; ++i) {
        //循环求前缀最大值
        int maxv = 0;
        for (int j = 1; j <= n; ++j) {
            //复用第二层循环，当i不变时，其实把j从1循环到后面
            //在这个判断中，maxv = f[i][j - 1]
            f[i][j] = f[i - 1][j];
            //a[i]一定在lcis中
            if(a[i] == b[j]) f[i][j] = max(maxv,f[i][j]);

            //前缀计算
            if(b[j] < a[i]) maxv = max(f[i][j] + 1,maxv);
        }
    }
    int res = 0;
    for (int i = 1; i <= n; ++i) {
        res = max(f[n][i],res);
    }
    cout << res << endl;
    return 0;
}