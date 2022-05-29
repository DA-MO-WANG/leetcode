//
// Created by rich heart on 5/29/22.
//
#include <iostream>
#include <cstring>
#include <algorithm>

using  namespace std;
const int N = 1e5 + 10;
int n;
//用数组模拟堆
int h[N],size;
char op[3];
//堆编序（显式序号）---堆中编号指的值是变化的，编号的指的是位置，而不是值==>s
//唯一标识（根本序号）——最开始的数据绑定的信号，值-标识的绑定是不变的==》idx
//ph==> idx->hp_idx; hp==>hp_idx->idx
int idx, ph[N],hp[N];
void heap_swap(int heap_idx1,int heap_idx2) {

    swap(ph[hp[heap_idx1]],ph[hp[heap_idx2]]);
    swap(hp[heap_idx1],hp[heap_idx2]);
    swap(h[])

}
void down(int index) {
    if(index > size) return;
    int min = index;
    int lc = 2 * index, rc = 2 * index + 1;
    if(lc <= size && h[min] > h[lc]) min = lc;
    if(rc <= size && h[min] > h[rc]) min = rc;
    if(min != index) swap(h[min],h[index]);
    //?
    down(lc),down(rc);
}

void up(int index) {
    if(index <= 0) return;
    int f = index / 2;
    if(h[f] > h[index]) swap(h[f],h[index]);
    up(f);
}
void add(int x) {
    h[++size] = x;
    up(size);
}
void deleteMin() {
    swap(h[size],h[1]);
    size--;
    down(1);

}
int main() {
    while (n--) {
        scanf("%s",op);
        if(op[0] == 'I') {
            int x;
            scanf("%d",&x);
            add(x);
        }else if(op[0] == 'p') {
            printf("%d",h[1]);
        }else if(op[0] == 'D' && op[1] == 'M') {
            deleteMin();
        }else if(op[0] == 'D' && op[1] != 'M') {
            delete
            //难题：如何维护第k个插入
        }
    }





}
