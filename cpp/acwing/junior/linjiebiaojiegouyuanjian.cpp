//
// Created by rich heart on 24/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 100010, M = 100010;
//定义之前要明确的东西

//为每一个点维护一个链表：记录与这个点连接的关系
//h[N]中的N代表的是节点编号，也就是题目给出的a, b==》容量受节点数量约束
//h[N]记录的值是唯一标识idx,而这个唯一标识可通过e[M]数组绑定节点编号

//e[M]的作用就是将唯一标识idx和节点编号绑定在一起,链表每伸一条边，e[M]就得记录一个
//ne[M]的作用就是维护链表结构，表示链表的下一个节点的唯一标识
//ne[M],e[M] 的容量受边的数量限制，最大有N方个边

//idx是关系的唯一标识，关系是不重复的，（a,b）对是不重复的，所以是唯一标识
int h[N], e[M], ne[M], idx;
void add(int a, int b) {
    e[idx] = b;
    //这个点上多一条边，就意味链表增加一个节点
    //这里是头插法，所以ne[idx]维护的是上一个头节点（没改变之前的）
    ne[idx] = h[a];
    //更新头节点
    h[a] = idx;
    idx++;
}
int main() {
    //链表的初始化，值为-1，代表是NULL
    memset(h, -1, sizeof(h));
    return 0;
}