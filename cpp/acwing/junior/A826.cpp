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
int main() {
    int m;
    cin >> m;
    init();
    while(m--) {
        string o;
        cin >> o;
        char c = o[0];
        switch (c) {
            case 'H':
                add_head(o[1])

        }
    }
}
