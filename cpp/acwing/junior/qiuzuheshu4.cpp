//
// Created by rich heart on 08/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
const int N = 5010;
//准备a范围内个质数
int primes[N],cnt;
bool str[N];
//记录每个质因子对应的次数统计
int sum[N];
//筛出质数：1-a范围内的质数
void get_primes(int n) {
    for(int i = 2; i <= n; i++) {
        if(!str[i]) primes[cnt ++ ] = i;
        for(int j = 0; primes[j] <= n / i; j++) {
            st[primes[j] * i] = true;
            if(i % primes[j] == 0) break;
        }
    }
}
//n阶乘里包含p的次数：那个
int get(int n, int p) {
    int res = 0;
    while (n) {
        res += n / p;//第一次记录p的一倍的个数
        n /= p;//第二次记录p的多倍的次数
        //累加就是所有次数
    }
    return res;
}
//高精度运算
//a存储的是每次质数乘积的结果
vector<int> mul(vector<int> a, int b) {
    vector<int> c;
    int t = 0;
    for (int i = 0; i < a.size() || t ; i++) {
        t += a[i] * b;
        c.push_back(t % 10);
        t /= 10;
    }
    return c;
}
int main() {
    int a, b;
    cin >> a >> b;
    get_primes(a);
    //计算质数的次数
    for(int i = 0; i < cnt; i++) {
        int p = primes[i];
        sum[i] = get(a,p) - get(b,p) - get(a - b,p);
    }
    vector<int> res;
    res.push_back(1);
    //高精度乘法
    for(int i = 0; i < cnt; i++) {
        for(int j = 0; j < sum[i]; j++) {
            res = mul(res,primes[i]);
        }
    }
    for(int i = res.size() - 1; i >= 0; i--) printf("%d",res[i]);
    put("");
    }
    return 0;
}