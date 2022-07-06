//
// Created by rich heart on 06/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
typedef long long ll;
const int N = 1e5 + 10, mod = 1e9 + 10;
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
    fact[0] = infact[0] = 1;
    for(int i = 1; i < N; i++) {
       fact[i] = fact[i - 1] * i % mod;
       infact[i] = infact[i - 1] * qmi(i , mod - 2, mod) % mod;
    }
    cin >> n;
    while(n--) {
        int a, b;
        scanf("%d%d",&a,&b);
        printf("%d\n",(ll)fact[a] * infact[b-a] * infact[b] % mod);
    }
    return 0;
}