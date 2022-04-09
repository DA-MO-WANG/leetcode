//
// Created by rich heart on 4/9/22.
//
//单链表
//单链表的逻辑结构--也就是脱离代码层面的东西
//单链表的每个节点单位靠的指针来维护的；数组是靠物理连续性来维护的


//动态链表的实现
//靠new 来创建链表（重操作），性能耗损大---struct\new 来实现
// 静态链表的实现 ：通过数组来实现
//四个要素：e[], ne[], head, idx
//head 指的是逻辑上的头节点的位置
//idx值得是操作顺序，节点数量的插入顺序
//链表的结构关系，和单个链表的下标没关系；是ele[] 和 ne[] 的关系共同构建的;ne_index——ne_val，这个两者构成了一个链
//单独看ne-index 肯定是idx同步的
#include <algorithm>
#include <cstring>
#include <cstdio>

using namespace std;
const int N = 1e5 + 10;
int head, ele[N], ne[N], idx;

void init() {
    head = -1;
    idx = 0;
}
void add_front(int x) {
    ele[idx] = x;
    ne[idx] = ne[head];
    head = idx;
    idx++;

}
//在k位置之后，插入节点x
void add(int k, int x) {
    ele[idx] = x;
    ne[idx] = ne[k];
    ne[k] = idx;
    idx++;
}

void remove_front() {
    head = ne[head];
}
int main() {

}