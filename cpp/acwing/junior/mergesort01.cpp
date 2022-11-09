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
    
}
void merge_sort(int l, int r) {
    int mid = l + r >> 1;
    merge_sort(l, mid);
    merge_sort(mid + 1, r);
    merge(l,mid,r);
}

int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> q[i];
    }

    return 0;
}