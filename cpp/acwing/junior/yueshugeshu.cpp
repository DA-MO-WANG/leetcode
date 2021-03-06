//
// Created by rich heart on 06/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;
const int mod = 1e9 + 7;
typedef long long LL;
int n;

int main() {
    cin >> n;
    //primes为什么放在最外面？
    //因为题目要求的是所有数的乘机的约数个数，所有数乘积依赖的质因子和所有数依赖的质因子汇总起来是一样的
    unordered_map<int,int> primes;
    while (n--) {
        int x;
        cin >> x;
        for (int i = 2; i <= x / i ; ++i) {
            while(x % i == 0) {
                x /= i;//每个质因子对应的幂指数
                primes[i]++;
            }
        }
        if(x > 1) primes[x]++;//最后剩下的东西
    }
    LL t = 1;
    for(auto prime : primes) {
        int k = prime.second;
        t = t * (k + 1) % mod;
    }
   cout << (t % mod);

    return 0;
}