//
// Created by rich heart on 07/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int f[N], v[N];
int main() {
    int count = 0;
    while(int x, cin >> x) {
        v[++count] = x;
    }
    for (int i = 1; i <= count; ++i) {
        f[i] = 1;
        for (int j = 1; j < i; ++j) {
            if(v[j] >= v[i]) f[i] = max(f[i],f[j] + 1);
        }
    }
    int res = 0;
    for (int i = 1; i <= count; ++i) {
        res = max(res, f[i]);
    }
    cout << res << endl;
    if(count % res)cout << count / res << endl;
    else cout << count / res + 1 << endl;
    return 0;
}