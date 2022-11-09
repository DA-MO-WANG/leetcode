//
// Created by rich heart on 09/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], n;

int partition(int l, int r) {
    //确定枢纽点
    int pivot = (l + r) >> 1;
    //枢纽点归位，两侧一大一小分布处理
    int i = l - 1, j = r + 1;
    while(i < j) {
        do i++; while(q[i] < q[pivot]);
        do j--; while(q[j] > q[pivot]);
        if(i < j) swap(q[i],q[j]);
    }
    return j;
}
void quick_sort(int l, int r) {
    //递归元底
    if(l >= r) return;
    //找到分界位置-归位后分布
    int j = partition(l,r);
    //递归处理两侧
    quick_sort(l,j);
    quick_sort(j + 1, r);
}
int main() {
    //quick_sort的物理骨架
    cin >> n;
    for (int j = 0; j < n; ++j) {
        scanf("%d",q + j);
    }
    quick_sort(0,n - 1);
    for (int i = 0; i < n; ++i) {
        printf("%d ",q[i]);
    }

    return 0;
}