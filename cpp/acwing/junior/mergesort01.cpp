//
// Created by rich heart on 09/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], temp[N], n;

void merge(int l, int mid, int r) {
    //[l,mid] [mid + 1, r]
//
//    for (int i = l; i <= mid; ++i) left[i] = q[i];
//    for (int j = mid + 1; j <= r; ++j) right[j] = q[j];
    int k = 0, i = l, j = mid + 1;
    while(i <= mid && j <= r) {
        if(q[i] <= q[j]) temp[k++] = q[i++];
        else temp[k++] = q[j++];
    }
    while(i <= mid) temp[k++] = q[i++];
    while (j <= r) temp[k++] = q[j++];

    for (int m = l; m <= r; ++m) {
        q[m] = temp[m];
    }
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
        cout << q[j] << " ";
    }
    return 0;
}