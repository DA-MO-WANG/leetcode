//
// Created by rich heart on 10/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], temp[N], n;
void merge(int l, int mid, int r) {
    //拿原数据，从原结构
    int k = l, i = l, j = mid + 1;
    while(i <= mid && j <= r) {
        if(q[i] <= q[j]) temp[k++] = q[i++];
        else temp[k++] = q[j++];
    }
    while(i <= mid) temp[k++] = q[i++];
    while(j <= r) temp[k++] = q[j++];
    //放新数据到临时结构


    //临时结构数据回流到原结构
    for (int m = l; m <= r; ++m) {
        q[m] = temp[m];
    }
}

//递归外部框架
void merge_sort(int l, int r) {
    //设计递归触底逻辑
    if(l >= r) {
        return;
    }

    int mid = l + r >> 1;

    merge_sort(l, mid);
    merge_sort(mid + 1, r);
    merge(l, mid, r);
}
int main() {
    //要解决一堆数的排序问题——》采用归并排序方案

    //先把这堆数专门放进一个我控制的结构里——》数组
    scanf("%d",&n);
    for (int i = 0; i < n; ++i) {
        scanf("%d",q + i);
    }

    merge_sort(0,n - 1);

    for (int j = 0; j < n; ++j) {
        printf("%d ",q[j]);
    }

    return 0;
}