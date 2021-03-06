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
int h[N],se;
char op[10];
//堆编序（显式序号）---堆中编号指的值是变化的，编号的指的是位置，而不是值==>s
//唯一标识（根本序号）——最开始的数据绑定的信号，值-标识的绑定是不变的==》idx
//ph==> idx->hp_idx; hp==>hp_idx->idx
int idx, ph[N],hp[N];
void heap_swap(int heap_idx1,int heap_idx2) {

    swap(ph[hp[heap_idx1]],ph[hp[heap_idx2]]);
    swap(hp[heap_idx1],hp[heap_idx2]);
    swap(h[heap_idx1],h[heap_idx2]);

}
void down(int index) {
    //if(index > se) return;
    int min = index;
    int lc = 2 * index, rc = 2 * index + 1;
    if(lc <= se && h[min] > h[lc]) min = lc;
    if(rc <= se && h[min] > h[rc]) min = rc;
    if(min != index) {
        heap_swap(min,index);
        down(min);
    }
    //?
   // down(lc),down(rc);
}

void up(int index) {
    //if(index <= 0) return;
    int f = index / 2;
    //循环和递归有时候可以互用
    if(f && h[f] > h[index]) {
        heap_swap(f,index);
        up(f);
    }
}
void add(int x) {
    ++se;
    idx++;
    ph[idx] = se;
    hp[se] = idx;
    h[se] = x;
    up(se);
}
void deleteMin() {
    heap_swap(se,1);
    se--;
    down(1);

}
void deletes(int heap_idx) {
    heap_swap(heap_idx,se);
    se--;
    down(heap_idx);
    up(heap_idx);
}
void update(int heap_idx, int x) {
    h[heap_idx] = x;
    down(heap_idx);
    up(heap_idx);
}
int main() {
    scanf("%d",&n);
    while (n--) {
        scanf("%s",op);
        if(!strcmp(op,"I")) {
            int x;
            scanf("%d",&x);
            add(x);
        }else if(!strcmp(op,"PM")) {
            printf("%d\n",h[1]);
        }else if(!strcmp(op,"DM")) {
            deleteMin();
        }else if(!strcmp(op,"D")) {
            //难题：如何维护第k个插入
            int k;
            scanf("%d",&k);
            int heap_idx = ph[k];
            deletes(heap_idx);
        }else if(!strcmp(op,"C")) {
            int k, x;
            scanf("%d%d",&k,&x);
            int heap_idx = ph[k];
            update(heap_idx,x);
        }
    }





}
