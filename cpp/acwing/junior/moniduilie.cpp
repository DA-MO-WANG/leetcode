//
// Created by rich heart on 4/28/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>
//用数组模拟队列
using namespace std;
const int N = 1e5 + 10;
int q[N], hh, tt;
int m;
void init() {
    hh = 0,tt = -1;
}
void push(int x) {
    q[++tt] = x;
}
bool empty() {
    return hh > tt;
}
void pop() {
    ++hh;
}
int query() {
    return q[hh];
}
int main() {
    cin >> m;
    init();
    while (m--) {
        string s;
        cin >> s;
        if(s == "push") {
            int x;
            cin >> x;
            push(x);
        }else if(s == "empty") {
            bool isEmpty = empty();
            cout << (isEmpty ? "YES" : "NO") << endl;
        }else if(s == "pop") {
            pop();
        }else {
            int ele = query();
            cout <<  ele << endl;
        }
    }



}

