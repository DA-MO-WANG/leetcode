//
// Created by rich heart on 30/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
typedef long long ll;
const int N = 1e5 + 10;
int n;
int t[N];
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> t[i];
    }
    sort(t + 1,t + n + 1);
    ll res = 0;
    for (int i = 1; i <= n; ++i) {
        res += t[i] * (n - i);
    }
    cout << res << endl;
    return 0;
}