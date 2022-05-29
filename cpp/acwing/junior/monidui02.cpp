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
int hp[N],size;
char op[3];
void down(int index) {
    if(index > size) return;
    int min = index;
    int lc = 2 * index, rc = 2 * index + 1;
    if(lc <= size && hp[min] > hp[lc]) min = lc;
    if(rc <= size && hp[min] > hp[rc]) min = rc;
    if(min != index) swap(hp[min],hp[index]);
    //?
    down(lc),down(rc);
}

void up(int index) {
    if(index <= 0) return;
    int f = index / 2;
    if(hp[f] > hp[index]) swap(hp[f],hp[index]);
    up(f);
}
void add(int x) {
    hp[++size] = x;
    up(size);
}
void deleteMin() {
    swap(hp[size],hp[1]);
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
            printf("%d",hp[1]);
        }else if(op[0] == 'D' && op[1] == 'M') {
            deleteMin();
        }else if(op[0] == 'D' && op[1] != 'M') {
            delete
            //难题：如何维护第k个插入
        }
    }





}
