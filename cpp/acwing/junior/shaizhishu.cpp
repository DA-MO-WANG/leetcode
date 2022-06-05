//
// Created by rich heart on 05/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
//筛质数
//埃氏筛法——
//遇到一个质因子，把第一次存下来，然后把他的倍数都标记一下，下次遇到跳过
const int N = 1e6 + 10;
int n;
bool str[N];
int prime[N],cnt;
void sz(int n) {
    //[2,n-1]
    for (int i = 2; i <= n; ++i) {
        //质因子总是先于质因子的倍数而遇到
        if(!str[i]) {
           prime[cnt++] = i;

            for (int j = i + i; j <= n; j += i) {
                str[j] = true;
            }
        }
    }


}
int main() {
    cin >> n;
    sz(n);
    cout << cnt;
    return 0;
}