//
// Created by rich heart on 24/09/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int f[N],n;
int v[4] = {10,20,50,100};
int main() {
    cin >> n;
    for (int i = 0; i < 4; ++i) {
        for (int j = v[i]; j <= n; ++j) {
            f[j] += f[j - v[i]];
        }
    }
    cout << f[n];
    return 0;
}