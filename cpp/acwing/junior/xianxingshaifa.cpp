//
// Created by rich heart on 05/06/2022.
//
//
// Created by rich heart on 05/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
//筛质数
//埃氏筛法——
//遇到一个质因子，把第一次存下来，然后把他的倍数都标记一下，下次遇到跳过
const int N = 1e6 + 10;
int n;
bool str[N];
int prime[N],cnt;
void sz(int n) {
    //[2,n] 所有可能的质数范围，不要与判断是不是质数混淆
    //n也要加入范围
    for (int i = 2; i <= n; ++i) {
        //质因子总是先于质因子的倍数而遇到
        //要么是第一次遇到的质因子，要么是被前面的质因子标记过的合数
        if(!str[i]) {
            prime[cnt++] = i;
        }

        //所有的合数都被标记过
        //遍历的是最小质因子
        // prime[j] <= n/i 包含了 j <=cnt

        //prime维护的是最小质因子
        //prime每更新一次，或者i更新一次，都会给标记的数带来变化

        //递增的数，的最小质因子也是不递减的，可以看成递增--线性的
        //===》每个数只会被标记一次
        //遍历的就是prime质因子数组——》去用当前质因子数组中的数去结合当前遍历的i，去筛掉一部分合数

        //无论当前i是不是质数，都要去标记
        for (int j = 0; prime[j] <= n /i ; ++j) {
            //根据这个最小质因子来标记一个
            str[prime[j] * i] = true;
            //保证prime j 是i的最小质因子——》prime[j]不能超过i的最小质因子
            //保证prime j 不能超过i,是i左边的数--保证当i是质因子本身时，当前质因子到当前质因子时就跳出
            if(i % prime[j] == 0) break;
        }

    }


}
int main() {
    cin >> n;
    sz(n);
    cout << cnt;
    return 0;
}