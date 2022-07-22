//
// Created by rich heart on 22/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010 ,mod = 1e9 + 7;
int n;
//朴素版本-三重循环
//int f[N][N];
//int main() {
//    cin >> n;
//    for (int i = 0; i <= n; ++i) f[i][0] = 1;
//    for (int i = 1; i <= n; ++i) {
//        for (int j = 1; j <= n; ++j) {
//            for (int k = 0; k * i <= j; ++k) {
//                f[i][j] = (f[i][j] + f[i - 1][j - k * i]) % mod;
//            }
//        }
//    }
//    cout << f[n][n];
//    return 0;
//}
//简化版本
int f[N];
int main() {
    cin >> n;
    //没有容量的话，也是一种方案
    f[0] = 1;

    for(int i = 1; i <= n; i++) {
        for (int j = i; j <= n; ++j) {
              f[j] = (f[j] + f[j - i]) % mod;
        }
    }
    cout << f[n] << endl;
    return 0;
};