//
// Created by rich heart on 5/6/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>
#include <cstdio>
#include <cmath>

using namespace std;
//用到了字典树的构造和遍历--特有的数组模拟的东西
const int N = 1e5 + 10, M = 31 * N;

int q[N], son[N][2], idx;
void insert(int x) {

    int p = 0;
    for (int i = 30; i >= 0 ; i--) {
        int u = x >> i & 1;//这个是获取第i位上二进制值的公式：先移i位，这样第i位上的数字就到了末位，然后与1 就获取了末位当位
        if(!son[p][u]) son[p][u] = ++idx;
        p = son[p][u];
    }
    //cnt[p]++; 因为能匹配最大异或值的肯定在叶子节点上，所以根本不需要记录非叶子节点上的数，也就是每个节点代表的是一个前缀位串集合
}
int query_maxyihuopipei(int x) {
    int p = 0, res = 0;
    for (int i = 30; i >= 0; i--) {

        int u = x >> i & 1;
        if(!son[p][!u]) {

            p = son[p][u];
            res = res * 2 + u;//从尾部添加1位，给整体带来的变化：*2  代表左移1位，腾出位置+末位
        }
        else {
            p = son[p][!u];
            res = res * 2 + !u;
        }
    }
    return res;//没有就是0

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
    for (int i = 0; i < n; ++i) {
        insert(q[i]);
        int x = query_maxyihuopipei(q[i]);
        res = max(res,x ^ q[i]);
    }







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
