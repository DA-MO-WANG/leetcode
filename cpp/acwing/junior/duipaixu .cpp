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
    int min = i;
    //如果左边界没过界
    if(i * 2 <= size && i * 2 + 1 > size && q[i] > q[i * 2]) min = i * 2;//要判断左子节点是否存在，判断的是左子节点是否越界
    else if(i * 2 + 1 <= size && q[i * 2 + 1] < q[i * 2] && q[i] > q[i * 2 + 1]) min = i * 2 + 1;
    else if(i * 2 + 1 <= size && q[i * 2] < q[i * 2 + 1] && q[i] > q[i * 2]) min = i * 2;
    if(min != i) {
        swap(q[i],q[min]);
        down(min);
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
