//
// Created by rich heart on 6/5/22.
//
#include <cstring>
#include <iostream>

using namespace std;

int n;
void fj(int n) {
    for (int i = 2; i <= n / i; ++i) {
        if(n % i == 0) {
            int count = 0;
            while(n % i == 0) {
                n /= i;
                count++;
            }
            cout << i << " " << count << endl;
        }
    }
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
