//
// Created by rich heart on 08/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;
int n;
int oula(int n) {
    int n1 = n;
    //先求出x的质因数
    unordered_map<int,int> primes;
    //1 不算质因子，从2开始
    //因为最多只有一个大于sqrt n的，所以i <= n /i
    for(int i = 2; i <= n /i; i++) {
        while(n % i == 0) {
            n /= i;
            primes[i]++;
        }
    }
    //应对最后一种情况
    if(n > 1) primes[n]++;
    int res = n1;
    for (auto prime : primes) {
        int p = prime.first;
        res = res / p * (p - 1);
    }
    return res;
}
int main() {
    cin >> n;
    while (n--) {
        int a;
        cin >> a;
        int res = oula(a);
        cout << res;
    }
    return 0;
}