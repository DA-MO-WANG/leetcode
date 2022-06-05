//
// Created by rich heart on 6/5/22.
//
#include <cstring>
#include <iostream>

using namespace std;

int n;
void fj(int n) {

    //优化原理：一个数最多又一个大于sqrtn的质因子，所以这个必然是最后一个因子
    //这最后一个不用放在循环里处理，因为i每次只能往前进1格，质因子之间的距离不是平均分布的
    //也就是万一，最后一个和倒数第二个小于sqrt n的之间的脚程万一很长，那不值得
    //因为有另一种简单的方式可以直接确定最后一个
    //i <= n/i 就是sqrt n 范围
    for (int i = 2; i <= n / i; ++i) {
        //要找质因数，从和他相关的约数找，约数中的质数，就是质因子
        if(n % i == 0) {//===》i是n的约数
            int count = 0;
            while(n % i == 0) {//质因数肯定在非质因数的约数组合的合数的约数的前面
                n /= i;
                count++;
            }
            cout << i << " " << count << endl;
        }
    }
    if(n > 1) cout << n << " " << 1 << endl;
    cout << endl;
}
int main() {
    cin >> n;
    while(n--) {
        int a;
        cin >> a;
        fj(a);
    }





}
