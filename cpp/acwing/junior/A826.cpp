//
// Created by rich heart on 4/10/22.
//
#include <algorithm>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
int head, e[N], ne[N], idx;
void init() {
    head = -1;
    idx = 0;
}
void add_head(int x) {
    e[idx] = x;
    ne[idx] = head;
    head = idx;
    idx ++;
}

void add(int k , int x) {
    e[idx] = x;
    ne[idx] = ne[k];
    ne[k] = idx;
    idx ++;
}
void remove(int k) {
    ne[k] = ne[ne[k]];
}
int main() {
    int m;
    cin >> m;
    init();
    while(m--) {
        //怎么接收带空格的一行数据？
        char o;
        cin >> o;
        switch (o) {
            int x, k;
            case 'H':
                x = 0;
                cin >> x;
                add_head(x);
                break;
            case 'D':
                k = 0;
                cin >> k;
                //特殊情况删除头节点
                if (k == 0) head = ne[head];
                //k指的是第k个数，从1算起，idx从0算起
                remove(k - 1);
                break;
            default:
                k = 0;
                x = 0;
                cin >> k >> x;
                add(k - 1,x);




        }

    }
    for(int i = head; i < m; i = ne[i]) {
        cout << e[i] << " " << endl;
    }
}
