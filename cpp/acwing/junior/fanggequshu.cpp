//
// Created by rich heart on 02/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 15;
int n;
//思路打通了，代码实现细节上还有很多值得推敲的地方
//这里状态表示是f(k,i1,i2)
//k不是指的走的步数，这里我理解错了——》k的变化的次数是受步数限制的
//k实质指的是坐标和，坐标和从1+1 变成 n + n ,经历了2n - 1 步变化
int f[N * 2][N][N], w[N][N];
int main() {
    cin >> n;
    int row , col, v;
    
    //这是一种写法技巧
    while (cin >> row >> col >> v, row || col || v) {
        w[row][col] = v;
    }
    //坐标和最开始是(1,1) ,也就是2，最大是(n,n) 也就是 2n
    for (int k = 2; k <= 2 * n; k++) {
        //i1代表的是其中一个指针的横坐标，因为和是定下来了，所以纵坐标可以做为衍生变量
        for (int i1 = 1; i1 <= n; ++i1) {
            for (int i2 = 1; i2 <= n; ++i2) {
                int j1 = k - i1, j2 = k - i2;
                if(j1 >=1 && j1 <= n && j2 >= 1 && j2 <= n) {
                    int t = w[i1][j1];
                    if(i1 != i2) t += w[i2][j2];
                    int &res = f[k][i1][i2];
                    res = max(res,f[k - 1][i1 - 1][i2 - 1] + t);
                    res = max(res,f[k - 1][i1 - 1][i2] + t);
                    res = max(res,f[k - 1][i1][i2 - 1] + t);
                    res = max(res,f[k - 1][i1][i2] + t);
                }

            }

        }
    }
    cout << f[2 * n][n][n] << endl;
    return 0;
}