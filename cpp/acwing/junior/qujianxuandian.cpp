//
// Created by rich heart on 26/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
//结构体是存储区间概念的组织结构
struct Range{
    int l, int r;
    //重载结构体的小于号，方便对区间结构排序
    bool operator< (const Range &w)const {
        return r < w.r;
    }
}range[N];
int n;
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int l, r;
        scanf("%d%d",&range[i].l,&range[i].r);
    }
    //先排序，方便后面单调求，使局部最优解=全局最优解
    sort(range,range + n);
    //设置最初的上一个选择的点为所有左端点中的最小值还要小
    int res = 0, ed = -2e9;
    //枚举每个区间，选择的点是基于区间情况来选的
    for (int i = 0; i < n; ++i) {
        //这是没有交集的情况
        if(ed < range[i].l) {
            res ++;
            ed = range[i].r;
        }
        //有交集的情况，上一个选择的点不变，点数也不变
    }
    cout << res << endl;
    return 0;
}