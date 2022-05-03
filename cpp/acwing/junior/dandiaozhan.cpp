//
// Created by rich heart on 4/28/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>
#include <cstdio>

using namespace std;
const int N = 1e5 + 10;
int q[N], tt, m;
int main() {
    cin >> m;
    for (int i = 0; i < m; ++i) {
        int x;
        cin >> x;
        //优势：排除了很多元素，而不用像暴力一样逐步遍历
        while(tt && q[tt] >= x) tt--;
        if(tt) cout << q[tt] << " ";
        else cout << -1 << " ";
        q[++tt] = x;
    }


}
