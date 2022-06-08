//
// Created by rich heart on 08/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
//1-n中每个数的欧拉函数之和
using namespace std;
const int N = 1e6 + 10;
int n;
//不要nsqrtn的复杂度==》线性筛法
int phi[N];
bool str[N];
int primes[N],cnt;

int sfoula(int n) {
    for (int i = 2; i < n; ++i) {
        if(!str[i]) {
            primes[cnt++] = i;
        }
        for (int j = 0; primes[j] <= n / i ; ++j) {
            str[primes[j] * i] = true;
            if(i % primes[j] == 0) break;
        }
    }
}

int main() {
    cin >> n;

    return 0;
}