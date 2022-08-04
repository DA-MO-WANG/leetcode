//
// Created by rich heart on 02/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int  M = 55, N = 55;
int m,n;
//思路打通了，代码实现细节上还有很多值得推敲的地方
//这里状态表示是f(k,i1,i2)
//k不是指的走的步数，这里我理解错了——》k的变化的次数是受步数限制的
//k实质指的是坐标和，坐标和从1+1 变成 n + n ,经历了2n - 1 步变化
int f[M + N - 1][M][M], w[M][N];
int main() {
    cin >> m >> n;
    for (int i = 1; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) {
            cin >> w[i][j];
        }
    }

    //坐标和最开始是(1,1) ,也就是2，最大是(n,n) 也就是 2n
    for (int k = 2; k < m + n; k++) {

        for (int i1 = 1; i1 <= m; ++i1) {
            //i2 做为第二个指针
            for (int i2 = 1; i2 <= m; i2++) {
                int j1 = k - i1, j2 = k - i2;
                if(j1 >=1 && j1 <= n && j2 >= 1 && j2 <= n) {
                    int t = w[i1][j1];
                    if(i1 != i2 && j1 != j2) t += w[i2][j2];
                    int &res = f[k][i1][i2];
                    //这里是四个依赖状态的max运算
                    res = max(res,f[k - 1][i1 - 1][i2 - 1] + t);
                    res = max(res,f[k - 1][i1 - 1][i2] + t);
                    res = max(res,f[k - 1][i1][i2 - 1] + t);
                    res = max(res,f[k - 1][i1][i2] + t);
                }

            }

        }
    }
    cout << f[m + n - 1][m][m] << endl;
    return 0;
}