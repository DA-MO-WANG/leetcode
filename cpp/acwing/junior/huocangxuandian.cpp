//
// Created by rich heart on 30/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
typedef long long ll;
const int N = 1e5 + 10;
int n;
int a[N];
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    sort(a + 1, a + n + 1);
    ll res = 0;
    for (int i = 1; i <= n; ++i) {
        res += abs(a[i] - a[n / 2]);
    }
    cout << res << endl;
    return 0;
}