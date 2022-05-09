//
// Created by rich heart on 5/9/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
const int N = 1e5 + 10;
int n, m, q[N], size;
void down(int i) {
    int t = 0;
    if(i * 2 <= size && i * 2 + 1 > size) t = i * 2;//要判断左子节点是否存在，判断的是左子节点是否越界
    else if(i * 2 <= size && i * 2 + 1 <= size) t = (q[i * 2] < q[i * 2 + 1] ? i * 2 : i * 2 + 1);
    while(q[i] > q[t]) {
        swap(q[i],q[t]);
        down(t);
    }
}
void removeTop() {
    q[1] = q[size];
    size--;
    down(1);
}
void heapfy() {
    for (int i = n/2; i >= 1 ; i--) {
        down(i);
    }
}
int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        size++;
        cin >> q[i];
    }
    heapfy();
    for (int j = 0; j < m; ++j) {
        cout << q[1] << " ";
        removeTop();

    }
}
