//
// Created by rich heart on 09/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], left[N],right[N],n;

void merge(int l, int mid, int r) {
    //[l,mid] [mid + 1, r]
    //设计两个数组来分别记录这两部分
    for (int i = l; i <= mid; ++i) left[i] = q[i];
    for (int j = mid + 1; j <= r; ++j) right[j] = q[j];
    int lt = l, rt = mid + 1, int cur = l;
    while(lt <= mid && rt <= r) {
        if(left[lt] <= right[rt]) q[cur++] = left[lt++];
        else q[cur++] = right[rt++];
    }
    while(lt <= mid) q[cur++] = left[lt++];
    while (rt <= r) q[cur++] = right[rt++];
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
    merge_sort(0,n - 1);
    for (int j = 0; j < n; ++j) {
        
    }
    return 0;
}