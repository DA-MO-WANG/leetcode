//
// Created by rich heart on 06/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

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
    //要考虑，凡事需要取模的地方，要注意溢出问题：涉及大数
    ll res = 1;
    for(auto prime : primes) {
        LL t = 1;
        //公式得记牢
        int p = prime.first;
        int k = prime.second;
        for (int i = 0; i < k; ++i) {
            //如何取模，才不破坏正确性
            t = (t * p + 1) % mod;
        }
        res = res * t % mod;
    }
    cout << res;

    return 0;
}