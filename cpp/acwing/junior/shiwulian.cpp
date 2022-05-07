//
// Created by rich heart on 5/7/22.
//
#include <algorithm>
#include <cstdio>
#include <iostream>
//并查集维护额外信息
 
using namespace std;
const int N = 50000;
int f[N], hg[N];
int find(int x) {
    if(f[x] != x) f[x] = find(f[x]);
    return f[x];
}
int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        f[i] = i;
    }
    int k;
    cin >> k;
    int res = 0;
    int d,x,y;
    while (k--) {
        cin >> d >> x >>y;
        if(x > n || y > n) ++res;
        if (d == 1) {
            if( (f[x] != x && f[y] != y ) && hg[x] != hg[y]) ++res;

        }else {
            if(d == 2) {
                if(x == y || f[x] == y || hg[x] - hg[y] < 0) ++res;
                f[y] = x;
                hg[y] += hg[x] + 1;
            }
        }
    }
    cout << res;
}
