//
// Created by rich heart on 06/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;
const int N = 110,mod = 1e9 + 7;

int n;
bool str[N];

int main() {
    cin >> n;
    int res = 1;
    unordered_map<int,int> primes;
    while (n--) {
        int a;
        cin >> a;
        for (int i = 2; i <=n / i ; ++i) {
            while(n % i == 0) {
                n /= i;//每个质因子对应的幂指数
                primes[i]++;
            }
            if(n > 1) primes[x]++;//最后剩下的东西
        }
    }
    for (auto prime : primes) {
        int p = prime.first, k = prime.second;
        int t = 1;
        t = p * t + 1;
    }
    res = res * t;
   cout << res;

    return 0;
}