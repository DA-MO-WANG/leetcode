//
// Created by rich heart on 09/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
typedef long long ll;
const int N = 1e5 + 10, mod = 1e9 + 7;
int fact[N], infact[N];
int n;
int qmi(int a, int k, int p) {
    int res = 1;
    while(k) {
        if(k & 1) res = (ll)res * a % p;
        a = (ll)a * a % p;
        k >>= 1;
    }
    return res;
}
int main() {
    cin >> n;
    //factn 代表n的阶乘
    //infact n 代表n阶乘的逆元
    fact[0] = infact[0] = 1;
    for(int i = 1; i < 2*N; i++) {
        fact[i] = (ll)fact[i - 1] * i % mod;
        infact[i] = (ll)infact[i - 1] * qmi(i , mod - 2, mod) % mod;
    }
    
    while(n--) {
        int a, b;
        scanf("%d%d",&a,&b);
        int res = (ll)fact[a] * infact[a - b] % mod * infact[b] % mod;
        printf("%d\n",res / (n + 1);
    }
    return 0;
}