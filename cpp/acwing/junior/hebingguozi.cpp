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
    priority_queue<int,vector<int>, greater<int>> heap;
    while (n--) {
        int x;
        cin >> x;
        heap.push(x);
    }
    int res = 0;
    while (heap.size() > 1) {
        int a = heap.top(), heap.pop();
        int b = heap.top(), heap.pop();
        res += a + b;
        heap.push(res);
    }
    cout << res << endl;
    return 0;
}