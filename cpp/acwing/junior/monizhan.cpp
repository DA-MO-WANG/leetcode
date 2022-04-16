//
// Created by rich heart on 4/16/22.
//
#include <cstring>
#include <iostream>
#include <algorithm>
//栈就是自缚手脚的数组，只维护一个指针的栈，通过指针才操作数组。而不是原生的上帝视角的数组
using namespace std;
const int N = 1e5 + 10;
int q[N], top = -1, down;
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
            top--;//逻辑删除，通过调整指针让你看不到，也是一种删除的意思
        }else if(ope == "empty") {
            cout <<((top == down) ? "YES" : "NO") << endl;
        }else {
            cout << q[top] << endl;
        }
    }
}

