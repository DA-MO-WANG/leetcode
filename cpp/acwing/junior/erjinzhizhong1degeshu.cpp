//
// Created by rich heart on 3/8/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;
//知识点：位运算
//子知识点：右移，与运算；二进制中的第k位（0开始计数）：先把第k位移到最后一位：右移运算；再看最后一位是1还是0： n & 1


int main() {
    int n;
    cin >> n;

    while(n--) {
        int x;
        cin >> x;
        int res = 0;
        while (x) x -= (x & -x), res++;
        cout << res << " ";

    }


    return 0;
}
