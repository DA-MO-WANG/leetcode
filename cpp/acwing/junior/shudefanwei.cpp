//
// Created by rich heart on 10/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], query, n;
int binary_search(int x, int option) {
    //区间具有的性质是比<= x
    int l = 0, r = n - 1;
    int mid = l + r >> 1;
    mid = option < 0 ? (l + 1 + r >> 1) : mid;


    while(l <= r) {
        if(check_left(q[mid],x)) l = mid;
        else r = mid - 1;
    }
    return mid;
}

bool check_left(int src, int to) {
    return src <= to ? true : to;
}
bool check_right() {
    return src >= to ? true : to;
}
int main() {
    //处理输入
    scanf("%d%d",&n,&query);
    for (int i = 0; i < n; ++i) {
        scanf("%d",q + i);
    }


    for (int j = 0; j < query; ++j) {
        int x;
        scanf("%d",&x);
        int first = binary_search(x,-1), last = binary_search(x, 1);
        printf("%d %d",first,last);
    }
    return 0;
}