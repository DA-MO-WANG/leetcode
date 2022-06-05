//
// Created by rich heart on 6/5/22.
//
#include <cstring>
#include <iostream>

using namespace std;

int n;
void fj(int n) {
    for (int i = 2; i <= n; ++i) {
        //要找质因数，从和他相关的约数找，约数中的质数，就是质因子
        if(n % i == 0) {//===》i是n的约数
            int count = 0;
            while(n % i == 0) {//质因数肯定在非质因数的约数组合的合数的约数的前面
                n /= i;
                count++;
            }
            cout << i << " " << count << endl;
        }
    }
    //if(n > 1) cout << n << " " << 1 << endl;
    cout << endl;
}
int main() {
    cin >> n;
    while(n--) {
        int a;
        cin >> a;
        fj(a);
    }





}
