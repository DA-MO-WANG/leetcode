//
// Created by rich heart on 27/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
const int N = 1e5 + 10;
struct Range{
    int l;
    int r;
    bool operator< (const Range &w)const {
        return l < w.l;
    }
}range[N];
int n;
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int l,r;
        cin >> l >> r;
        range[i] = {l,r};
    }
    sort(range,range + n);
    //小根堆能够实时维护所有组的最右右端点情况
    //还记录了组的数量，每个组在结构里只有一个元素
    priority_queue<int, vector<int>, greater<int>> heap;
    for (int i = 0; i < n; ++i) {
        auto t = range[i];
        //有交集情况-新开组
        //这里当第一次分组时，直接把第一个区间当第一组，也就是小根堆直接记录第一个区间右端点
        if(heap.empty() ||  heap.top() >= range[i].l) heap.push(t.r);
        else {
            //把当前区间加入到最小值所在组中
            heap.pop();
            heap.push(t.r);
        }
    }
    cout << heap.size() << endl;
    return 0;
}