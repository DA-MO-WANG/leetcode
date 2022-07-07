//
// Created by rich heart on 07/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
typedef long long ll;
int p;
int qmi(int a, int k) {
    int res = 1;
    while(k) {
        if(k & 1) res = (ll)res * a % p;
        a = (ll)a * a % p;
        k >>= 1;
    }
    return res;
}
int c(int a, int b) {
    int res = 1;
    for(int i = 1, j = a; i <= b; i++, j--) {
        // 分子对应的阶乘公式：a乘到a - b + 1
        //for的设计，这里很妙；用i的条件约束了j,j只会最小到a - b + 1
        res = (ll)res * j % p;
        //处理分母位置，除法又取模，可以转化为乘法的逆元--就用到快速幂
        //除从b到1，就连续乘从1到b的逆元
        res = (ll)res * qmi(i, p - 2) % p;
    }
    return res;
}
int locus(int a, int b) {
    //p范围内的数，这种数量级就可以选择另一条路
    if(a < p && b < p) return c(a,b);
    //对于超出p的范围的那些大数，进行减而治之
    //一部分当堂算出结果，一部分降级处理
    return (ll)c(a % p, b % p) * locus(a / p, b / p);
}
int main() {
    int n;
    cin >> n;
    while(n--) {
        ll a, b;
        cin >> a >> b >> p;
        cout << locus(a,b) << endl;
    }
    return 0;
}