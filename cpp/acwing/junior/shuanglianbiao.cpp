//
// Created by rich heart on 4/16/22.
//
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
//用数组模拟双链表
const int N = 1e5 + 10;
int e[N],l[N],r[N], idx;
void init() {
    //设置两个不存实际值的辅助节点head\tail
    //idx=0为head,idx=1为tail,因为一个在头，一个在尾，只有单侧指针
    l[1] = 0, r[0] = 1;
    idx = 2;
}
//在位置为k的节点后面添加一个节点
void add_right(int k, int x) {

    e[idx] = x;
    //第一步
    r[idx] = l[k];
    l[idx] = k;
    l[r[k]] = idx;
    r[k] = idx;
    idx++;
}

//在位置为k的左部插入一个节点
void add_left(int k, int x) {

}
int main() {
    int m = 0;
    cin >> m;
    while(m--) {
        char ope = ' ';
        cin >> ope;
        if(ope == 'L') {
            int x = 0;
            cin >> x;
            add_right(0,x);
        }else if(ope == 'R') {

        }else if(ope == 'D') {

        }else if(ope == 'IL') {

        }else if(ope == 'IR') {

        }
    }
}
