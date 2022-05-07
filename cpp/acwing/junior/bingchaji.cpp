//
// Created by rich heart on 5/7/22.
//
#include <algorithm>
#include <cstdio>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
int n, m, f[N];
//查找某个数据的祖宗节点
int find(int x) {
    while(f[x] != x) {
        f[x] = find(f[x]);
    }
    return f[x];
}
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        f[i] = i;
    }
    cin >> m;
    while (m--) {
        char[2] op;
        cin >> op;
        if(op[0] == 'M') {
            int x,y;
            cin >> x >> y;
            f[find(x)] = find(y);
        }else {
            int x, y;
            cin >> x >> y;
            cout << (find(x) == find(y) ? "Yes" :"No") << endl;
        }
    }

}
