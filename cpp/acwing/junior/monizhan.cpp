//
// Created by rich heart on 4/16/22.
//
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int q[N], top, down;
int main() {
    int m;
    cin >> m;
    while(m--) {
        string ope = "";
        cin >> ope;
        if(ope == "push") {
            int x;
            cin >> x;
            q[++top] = x;
        }else if(ope == "pop") {
            q[top--] = 0;
        }else if(ope == "empty") {
            cout <<((top == down) ? "YES" : "NO");
        }else {
            cout << q[top];
        }
    }
}

