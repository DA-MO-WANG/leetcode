//
// Created by rich heart on 4/16/22.
//
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
//用数组模拟双链表
//关键就是画图，照着图的操作逻辑映射成代码
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
    r[idx] = r[k];
    l[idx] = k;
    l[r[k]] = idx;
    r[k] = idx;
    idx++;
}

//在位置为k的左部插入一个节点
void add_left(int k, int x) {
    e[idx] = x;
    r[idx] = k;
    l[idx] = l[k];
    r[l[k]] = idx;
    l[k] = idx;
    idx++;
}

void remove(int k) {
    r[l[k]] = r[k];
    l[r[k]] = l[k];
}
int main() {
    init();
    int m = 0;
    cin >> m;
    while(m--) {
        string ope = "";//字符串类可以直接==比较
        int k,x;//cin可以不断替换掉旧值
        cin >> ope;
        if(ope == "L") {

            cin >> x;
            add_right(0,x);
        }else if(ope == "R") {

            cin >> x;
            add_left(1,x);
        }else if(ope == "D") {

            cin >> k;
            remove(k+1);//对第k个插入的数的理解，最终落实到相应的idx值，因为idx从2算起，k从1算起，所以换算成idx为k+1
        }else if(ope == "IL") {

            cin >> k >> x;
            add_right(l[k + 1],x);
        }else if(ope == "IR") {

            cin >> k >> x;
            add_right(k + 1,x);
        }
    }

    for(int i = r[0]; i != 1; i = r[i]) {//遍历链表从头节点指向的第一个元素开始
        //迭代是右指针公式
        //判断条件是尾节点位置
        cout << e[i] << ' ';
    }
    return 0;
}
