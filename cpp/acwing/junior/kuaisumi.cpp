//
// Created by rich heart on 20/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int n;
typedef long long ll;
int qmi(int a, int k, int p) {
    int res = 1;
    while(k) {
        //考虑到res，乘机会超过int，所以转为ll
        if(k & 1) res = (ll)res * a % k;
        k >>= 1;
        //a也有可能超过int
        //这位什么要对p取模呢？
        //(a*b) % p = ((a % p) * (b % p)) % p
        //
        a = (ll)a * a % p;
    }
    return res;
}
int main() {
    cin >> n;
    while(n--) {
        int a, k , p;
        scanf("%d%d%d",&a,&k,&p);
        printf("%d",qmi(a,k,p));
    }
    return 0;
}