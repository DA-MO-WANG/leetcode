//
// Created by rich heart on 5/10/22.
//
#include <algorithm>
#include <iostream>
//难点在于：怎么维护插入的顺序和堆顺序的映射
//什么时候要维护这两个关系的映射
using namespace std;
const int N = 1e5 + 10;
int h[N],se,hp[N],ph[N],idx;
void heap_swap(int index1, int index2) {
    swap(ph[hp[index1]],ph[hp[index2]]);
    swap(hp[index1],hp[index2]);
    swap(h[index1],h[index2]);
}
void up(int index) {
    //int min = index;
//    if(index / 2 && h[index] < h[index / 2]) min = index / 2;
//    if(min != index) {
//        heap_swap(min,index);
//        up(min);
//    }
    while(index / 2 && h[index / 2] > h[index]) {
        heap_swap(index /2,index);
        index = index / 2;
    }
}
void down(int index) {
    int min = index;
    if(index * 2 <= se && h[index * 2] < h[index]) min = index * 2;
    if(index * 2 + 1 <= se && h[index * 2 + 1] < h[index]) min = index * 2 + 1;
    if(min != index) {
        heap_swap(index,min);
        down(min);
    }
}
void insert(int x) {
    se++;
    h[se] = x;
    idx++;
    //维护插入顺序和堆顺序的映射关系
    ph[idx] = se;
    hp[se] = idx;
    up(se);
}
void remove() {
    heap_swap(1,se);
    se--;
    down(1);

}
void D(int k) {
    int index = ph[k];
    //h[index] = h[se];
    heap_swap(index,se);
    se--;
    down(index);
    up(index);
}
void C(int k, int x) {
    int index = ph[k];
    h[index] = x;
    down(index);
    up(index);
}

int main() {
    int n;
    cin >> n;
    while (n--) {
        string s;
        cin >> s;
        if(s == "I") {
            int x;
            cin >> x;
            insert(x);
        }else if(s == "PM") {
            cout << h[1] << endl;
        }else if(s == "DM") {
            remove();
        }else if(s == "D") {
            int k;
            cin >> k;
            D(k);

        }else if(s == "C") {
            int k, x;
            cin >> k >> x;
            C(k,x);
        }
    }
    return 0;
}
