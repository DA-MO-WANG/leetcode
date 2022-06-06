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
unordered_map<int,int> primes;
void yueshugeshu(int n) {
    for (int i = 1; i <=n ; ++i) {
        if(n % i == 0) {
            if(!str[i]) primes[i]++;
        }
        for (int j = i + i; j <=n; j += i) {
            str[j] = true;
        }
    }
}
int main() {
    cin >> n;

    while (n--) {

    }

    int res = 1;
    for (auto prime : primes) {
        int p = prime.first, k = prime.second;
        int t = 1;
        t = p * t + 1;
    }
    res = res * t;
    return 0;
}