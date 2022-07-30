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
    //通过计算每个人要等待的时间，然后一共等待的时间之和的公式揭示出一个性质
    //每次让快的在前面，让慢的在后面
    sort(t + 1,t + n + 1);
    ll res = 0;
    for (int i = 1; i <= n; ++i) {
        res += t[i] * (n - i);
    }
    cout << res << endl;
    return 0;
}