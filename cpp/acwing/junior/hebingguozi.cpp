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
    return 0;
}