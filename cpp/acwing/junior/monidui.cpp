//
// Created by rich heart on 5/10/22.
//
#include <algorithm>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
int h[N],se,hp[N],ph[N],idx;
int n, x;
void heap_swap(int index1, int index2) {
    swap(ph[hp[index1]],ph[hp[index2]]);
    swap(hp[index1],hp[index2]);
    swap(h[index1],h[index2]);
}
void up(int index) {
    int min = index;
    if(index / 2 && h[index] < h[index / 2]) min = index / 2;
    if(min != index) {
        heap_swap(min,index);
        up(min);
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
    h[++se] = x;
    idx++;
    //维护插入顺序和堆顺序的映射关系
    ph[idx] = se;
    hp[ph[idx]] = idx;
    up(ph[idx]);
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

        }else {
            int k, x;
            cin >> k >> x;
            C(k,x);
        }
    }
}
