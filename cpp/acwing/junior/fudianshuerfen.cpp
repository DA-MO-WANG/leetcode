//
// Created by rich heart on 15/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
//运用二分技巧来实现浮点数求平方根
using namespace std;
//先找二分区间——》[0,x]数学上平方根只有一个，但是求解的时候，任何数都可以做平方根
//平方根解区间，的极限边界点就是数学精确值，但这里永远无法用计算机确定的
//我们只能找到一个约定误差范围的——tip: 比约定多2位
int main() {
    double x;
    cin >> x;
    int l = 0, r = x;
    while(r - l <= 1e-8) {
        int mid = (l + r) >> 1;
        if(mid * mid <= x) l = mid;
        else r = mid;

    }
    cout << r;
    return 0;
}