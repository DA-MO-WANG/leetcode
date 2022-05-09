//
// Created by rich heart on 5/9/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
const int N = 1e5 + 10;
int n, m, q[N], se;
void down(int i) {
    int min = i;
    //求三个点中的最小值的三种情况
    if(i * 2 <= se  && q[i] > q[i * 2]) min = i * 2;//要判断左子节点是否存在，判断的是左子节点是否越界
    else if(i * 2 + 1 <= se && q[i] > q[i * 2 + 1]) min = i * 2 + 1;
    if(min != i) {
        swap(q[i],q[min]);
        down(min);
    }
}
void removeTop() {
    q[1] = q[se];
    se--;
    down(1);
}
void heapfy() {
    for (int i = n/2; i ; i--) {
        down(i);
    }
}
int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        se++;
        cin >> q[i];
    }
    heapfy();
    for (int j = 0; j < m; ++j) {
        cout << q[1] << " ";
        removeTop();

    }
}
