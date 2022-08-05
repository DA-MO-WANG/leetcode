//
// Created by rich heart on 05/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int v[N],f[N];
int n;
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> v[i];
        f[i] = 1;
    }
    for (int i = 0; i < n; ++i) {
        for (int k = 0; k < i; ++k) {
            if(v[k] < v[i]) f[i] = max(f[i],f[j] + 1);
        }
    }
    int res = 0;
    for (int i = 0; i < n; ++i) {
        res = max(f[i],res);
    }
    cout << res << endl;
    return 0;
}