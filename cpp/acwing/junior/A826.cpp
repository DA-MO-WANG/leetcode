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
//最开始的时候，头插就保证了尾节点指向null
//自此以后，所有的插入都不破坏这个特性；无论是中间插入，后半段也是尾部null，还是尾插，比头插多了一步，维护前面的数据
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
    //这里为什么是-1标志结束？==》尾部是null的特性
    for(int i = head; i != -1; i = ne[i]) {
        cout << e[i] << " ";
    }
}
//head 是最原始的时候就维护头节点，这是逻辑的元点，特定的idx，链表的入口，有了这个idx 才能找到节点的值，还有去ne中找下一个节点的idx,以此串起来
//idx 和节点顺序没关系，或者刚开始的时候重合，但实质只是记录了操作顺序/插入顺序，这种东西引入删除操作时，就乱了
//idx只维护了一个过程，只能增，只能往前走
//e是维护数据的，删除节点时，也是调整逻辑指针（改变ne值），不涉及数据的物理删除
