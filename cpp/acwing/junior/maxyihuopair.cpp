//
// Created by rich heart on 5/6/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>
#include <cstdio>
#include <cmath>

using namespace std;
//要
const int N = 1e5 + 10;
int q[N];
int main() {

    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> q[i];
    }
    int res = 0;
    for (int i = 0; i < n; ++i) {
        //先写出暴力解法
        for (int j = i + 1; j < n; ++j) {
            res += Math.max(q[i] ^ q[j]);
        }
    }
}
