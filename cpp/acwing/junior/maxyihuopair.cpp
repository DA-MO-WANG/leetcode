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

int q[N], son[N][2], cnt[N], idx;
void insert(int x) {
    //我要获取i位上对应的二进制的值
    int p = 0;
    for (int i = 31; i >= 0 ; i--) {
        int u = x >> 1 & 
    }
}
int main() {

    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> q[i];
    }
    int res = 0;
    //优化解法
    //因为异或运算都是基于位的运算，所以我把所有数看作位组织形式
    //因为我要找的是最大的异或值，所以我先关注高位的异或运算
    //如果我能找到能够得到最大异或值的数，每给我一个数，我都能从集合里最高31次，就能找到
    //这个找到最大异或的规则是：从高位起，如果待匹配的数的这一位是0，那我就选择1这个分支，
    // 如果没有理想分支的话，我就选择将就的已有的选择







    //先写出暴力解法
//    for (int i = 0; i < n; ++i) {
//
//        //因为c++ 1s可以执行10的5-7次幂，而n的2次幂的复杂度，10的10次幂运算，最大，所以必然超时
//        for (int j = i + 1; j < n; ++j) {
//            res = max(res,q[i] ^ q[j]);
//        }
//    }
    cout << res;
}
