//
// Created by rich heart on 6/4/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
int n;

bool is_prime(int a) {
    if(a <= 2) return false;
    for (int i = 2; i < a / i; ++i) {
        if(a % i == 0) return false;
    }
    return true;
}
int main() {
    cout << n;
    while(n--) {
        int a;
        cin >> a;
        bool res = is_prime(a);
        if(res) cout << "Yes";
        else cout << "No";
    }
}

