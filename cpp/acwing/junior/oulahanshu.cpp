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
    //先求出x的质因数
    unordered_map<int,int> primes;
    for(int i = 1; i <= n /i; i++) {
        while(n % i == 0) {
            n /= i;
            primes[i]++;
        }
    }

    int res = n;
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