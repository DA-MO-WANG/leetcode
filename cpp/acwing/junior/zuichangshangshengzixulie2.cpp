//
// Created by rich heart on 19/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int n;
int v[N];
//记录遍历存储不通长度的上升子序列最小结尾元素数组的元素
int q[N];
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> v[i];
    }
    //记录数组重的元素数目
    int len = 0;
    //遍历存储不通长度的上升子序列最小结尾元素数组的元素
    //设计哨兵节点，处理边界情况
    q[0] = -2e9;
    for (int i = 0; i < n; ++i) {
        int l = 0, r = len;
        //二分查找，找的是q数组中，比v[i]小的最大的元素
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(q[mid] < v[i]) l = mid;
            else r = mid - 1;
        }
        //v[i]对应的序列的长度为找到的那个值的长度+1
        len = max(len,r + 1);
        q[r + 1] = v[i];

    }
    cout << len << endl;
    return 0;
}