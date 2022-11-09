//
// Created by rich heart on 09/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], n;

void merge(int l, int mid, int r) {
    //[l,mid] [mid + 1, r]
    //设计两个数组来分别记录这两部分
    
}
void merge_sort(int l, int r) {
    //确定分界点
    int mid = l + r >> 1;
    //递归拆分2部分
    merge_sort(l, mid);
    merge_sort(mid + 1, r);
    //递归底部，返回时开始合并逻辑
    merge(l,mid,r);
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> q[i];
    }

    return 0;
}