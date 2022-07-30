//
// Created by rich heart on 30/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
int n;
int main() {
    cin >> n;
    //为了准备：每次都能选出最小的两个元素
    priority_queue<int,vector<int>, greater<int>> heap;
    while (n--) {
        int x;
        cin >> x;
        heap.push(x);
    }
    //记录体力结果
    int res = 0;
    while (heap.size() > 1) {
        int a = heap.top(); heap.pop();
        int b = heap.top();heap.pop();
        //每次把现存的最小的两个元素合并
        int cob = a + b;
        //合并之后形成新的一堆，然后放进队列中维护，方便下一次合并
        heap.push(cob);
        res += cob;
    }
    cout << res << endl;
    return 0;
}