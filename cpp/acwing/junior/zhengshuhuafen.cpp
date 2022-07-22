//
// Created by rich heart on 22/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int n;
int f[N];
int main() {
    cin >> n;
    f[0] = 1;
    for (int i = 1; i <= n; ++i) {
        for (int k = 1; k <= i; ++k) {
            f[i] += f[i - k];
        }
    }
    cout << f[n];
    return 0;
}