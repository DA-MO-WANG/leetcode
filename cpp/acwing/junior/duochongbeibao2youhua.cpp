//
// Created by rich heart on 17/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 11010, M = 2010;
//开多大空间
//2000子物品数量，1000物品种类=》每个2000，对应2的11幂，11*1000
//cnt的限制
int v[N], w[N];
int f[M];
int n, m;
int main() {
    cin >> n >> m;
    //新物品的编号
    int cnt = 0;
    for (int i = 1; i <= n; ++i) {
        //a是体积属性、b是价值属性、s是数量
        int a, b ,s;
        cin >> a >> b >> s;
        //k是分割s的挡板
        int k = 1;
        while(k <= s) {
            cnt ++;
            v[cnt] = a * k;
            w[cnt] = b * k;
            //更新循环变量
            s -= k;
            k <<= 1;
        }
        //求c
        //剩下s数量
        if(s) {
            cnt ++;
            v[cnt] = a * s;
            w[cnt] = b * s;
        }
    }
    //01背包
    n = cnt;
    for (int i = 1; i <= n; ++i) {
        for (int j = m; j >= v[i] ; j--) {
            f[j] = max(f[j],f[j - v[i]] + w[i]);
        }
    }
    cout << f[m] << endl;
    return 0;
}