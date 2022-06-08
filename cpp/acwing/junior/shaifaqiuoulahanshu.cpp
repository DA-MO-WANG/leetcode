//
// Created by rich heart on 08/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
//1-n中每个数的欧拉函数之和
using namespace std;
typedef long long LL;
const int N = 1e6 + 10;
int n;
//不要nsqrtn的复杂度==》线性筛法
int phi[N];
bool str[N];
int primes[N],cnt;

LL sfoula(int n) {
    phi[1] = 1;//从1开始的
    for (int i = 2; i <= n; ++i) {
        //每一个合数都是由前边的质因子组合成，也就是前边的质因子和当前的数都够代表所有的合数
        if(!str[i]) {//合数的肯定都被标记的，没被标记的一定是质因子
            primes[cnt++] = i;
            phi[i] = i - 1;
        }
        for (int j = 0; primes[j] <= n / i ; ++j) {
            str[primes[j] * i] = true;
            if(i % primes[j] == 0) {//到当前i的第一个质因子那跳出
                phi[primes[j] * i] = phi[i] * primes[j];
                break;
            }
            phi[primes[j] * i] = phi[i] * (primes[j] - 1);
        }
    }
    LL res = 0;
    //计算欧拉从1开始
    for (int k = 1; k <= n; ++k) {
        res += phi[i];
    }
    return res;
}

int main() {
    cin >> n;
    LL res  = sfoula(n);
    cout << res;
    return 0;
}