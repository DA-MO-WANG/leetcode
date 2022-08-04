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
            //i2 做为第二个指针
            for (int i2 = 1; i2 <= n; ++i2) {
                int j1 = k - i1, j2 = k - i2;
                //三重循环当中，不一定都是不合法的，因为k = 1时，i1 = 5，那么就会出现负值
                //所以就需要越界判断，只有在合法的坐标状态中，才进行处理
                if(j1 >=1 && j1 <= n && j2 >= 1 && j2 <= n) {
                    //这里的技巧可能不可能加两次，先加一次，第二次根据判断单独加，这样就包含了两种情况
                    //t 代表的是当前状态的增量
                    int t = w[i1][j1];
                    //当前状态处于同一个格子时，只需要计算一次，这也是题目中置为0的一种意思
                    if(i1 != i2) t += w[i2][j2];99
                    //引用的技巧，我把引用和变量弄混了，引用是给一个对象起别名，始终操作的是不变的对象
                    //这里的增量，只是一个数量，不能适用引用，若用引用，会改变原始w[i1][j1]的值
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
    cout << f[2 * n][n][n] << endl;
    return 0;
}