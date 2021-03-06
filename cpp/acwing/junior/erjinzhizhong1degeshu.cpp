//
// Created by rich heart on 3/8/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;
//知识点：位运算
//子知识点：右移，与运算；二进制中的第k位（0开始计数）：先把第k位移到最后一位：右移运算；再看最后一位是1还是0： n & 1

//子知识点2：lowbit()运算-返回最后一个1及之后的部分：位运算不改变数据类型，位形式做减法，等同于其他进制
//负数二进制表示的概念：原数取反+1
//论证：x +(-x) = 0 => -x = 0 -x => 32个0做减法，借位，借来1，相当于取反+1的效果
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
