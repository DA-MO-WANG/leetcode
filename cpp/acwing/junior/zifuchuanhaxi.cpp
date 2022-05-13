//
// Created by rich heart on 5/13/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
//一种简便写法技巧
typedef unsigned long long ull;
const int N = 1e5 + 10, P = 131;
int n,m;
int h[N],p[N];
char str[N];


void mi() {
    p[0] = 1;
    for (int i = 1; i <= n; ++i) {
        p[i] = p[i - 1] * P;
    }
}


//预先把字符串涉及的前缀都存储起来
void prefix_hash() {
    h[0] = 0;
    for (int i = 1; str[i]; ++i) {
        h[i] = h[i - 1] * P  + str[i];
    }
}

int qujianhash(int l, int r) {
    return h[r] - h[l - 1] * p[r - l + 1];
}
int main() {
    cin >> n >> m;
    mi();
    scanf("%s",str+1);
    prefix_hash();
    while(m--) {
        int l1, r1, l2, r2;
        cin >> l1 >> r1 >> l2 >> r2;
        if(qujianhash(l1,r1) == qujianhash(l2,r2)) {
            cout << "Yes" << endl;
        }else {
            cout << "No" << endl;
        }
    }




}
