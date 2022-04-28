//
// Created by rich heart on 4/28/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
int q[N], tt, m;
int main() {
    cin >> m;
    for (int i = 0; i < m; ++i) {
        int x;
        cin >> x;
        while(tt && q[tt] >= x) tt--;
        if(tt) cout << q[tt] << " ";
        q[++tt] = x;
    }

}
