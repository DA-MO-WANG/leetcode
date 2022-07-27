//
// Created by rich heart on 27/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
//最大不相交的区间的数量
//只有选择前后区间时，在不破坏相交的条件下，距离越近越好，也就是右端点越小越好
//而排序后的相邻特性，满足这个要求
//这种策略局部距离最近==》全局个数最多
using namespace std;
const int N = 1e5 + 10;
struct Range{
    int l;
    int r;
    bool operator< (const Range &w)const {
        return r < w.r;
    }
}range[N];
int n;
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int l, r;
        cin >> l >> r;
        //结构体还可以这样赋值
        range[i] = {l,r};
    }
    sort(range,range + n);
    int res = 0, ed = -2e9;
    for (int i = 0; i < n; ++i) {
        if(ed < range[i].l) {
            res++;
            ed = range[i].r;
        }
    }
    cout << res << endl;
    return 0;
}