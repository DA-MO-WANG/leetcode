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
    //假设理论最小值就是实际最小值
    int min = i;
    //求三个点中的最小值的三种情况
    if(min * 2 <= se  && q[min] > q[i * 2]) min = min * 2;//要判断左子节点是否存在，判断的是左子节点是否越界
    else if(min * 2 + 1 <= se && q[min] > q[i * 2 + 1]) min = min * 2 + 1;
    //校验实际最小值和理论最小值的是否相同
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
    //利用了递归思想：从底部向上，每一棵子树都能做到维护堆定义，那么由子树构成的树也符合堆定义
    for (int i = n/2; i ; i--) {
        down(i);
    }
}
int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) {
        cin >> q[i];
    }
    se = n;
    heapfy();
    for (int j = 0; j < m; ++j) {
        cout << q[1] << " ";
        removeTop();

    }
}
