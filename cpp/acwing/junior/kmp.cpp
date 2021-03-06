//
// Created by rich heart on 5/5/22.
//

#include <algorithm>
#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 1e5 + 10, M = 1e6 + 10;
int n, m, ne[N];
char p[N], s[M];
int main() {
    cin >> n >> p + 1 >> m >> s + 1;

    //创建next[]
    for (int i = 2, j = 0; i < n; ++i) {
        while(j && p[i] != p[j + 1]) j = ne[j];
        if(p[i] == p[j + 1]) j++;
        ne[i] = j;
    }

    //开始匹配
    for (int i = 1, j = 0; i < m; ++i) {
        while(j && s[i] != p[j + 1]) j = ne[j];
        if (s[i] == p[j + 1]) j++;
        if(j == n) {
            cout << i - n + 1 << " ";
            j = ne[j];
        }

    }
}