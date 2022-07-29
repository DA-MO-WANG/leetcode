//
// Created by rich heart on 28/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>


using namespace std;
const int N = 1e5 + 10;
struct Range{
    int l;
    int r;
    bool operator< (const Range &w)const  {
        return l < w.l;
    }
}range[N];
int start, t;
int n;
bool success;
int main() {
    cin >> start >> t;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int l, r;
        cin >> l >> r;
        range[i] = {l, r};
    }
    sort(range,range + n);
    int res = 0;
    for (int i = 0; i < n; i++) {
        //技巧点：双指针如何实现
        //双指针的作用就是找到在覆盖这些点的区间中找到一个右端点最大的那个区间
        //双指针适用双重递进条件的情况

        //从外层i循环的情况出发，不破坏外层循环
        //需要设计一个临时的存储右端点的变量，每个start都要重新初始化这个变量，这个变量的初始值不影响max结果
        int j = i , r = -2e9;
        //覆盖这个点：range[i].l < start
        while(j < n && range[j].l <= start) {
            //找到覆盖这个点的区间右端点最大的区间
            r = max(r,range[j].r);
            //循环覆盖start这个点的多个区间
            j++;
        }
        //区间够不着start
        if(r < start) break;
        //选上了覆盖，res结果记为+1
        res++;
        //这个区间已经覆盖完了
        if(r >= t) {
            success = true;
            break;
        }
        //更新start-这个选中覆盖的区间的右端点
        start = r;
        //下次覆盖从当前选中区间的下一个区间开始
        //j ++ -1 + 1
        i = j - 1;
    }
    if(!success) res = -1;
    cout << res << endl;
    return 0;
}


for(int i = 0; i< n; i++) {
    int j = i;
    while(j < n && 条件1) {
        条件2;
        j++;
    }
    //外层循环从满足条件的j之后开始
    i = j - 1;
}