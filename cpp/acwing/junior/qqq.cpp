//
// Created by rich heart on 5/7/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
int f[N],size[N];
int find(int x) {
    if(f[x] != x) f[x] = find(f[x]);
    return f[x];
}
int main() {
    //玩家数量
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        f[i] = i;
        size[i] = 1;
    }
    //总操作数
    int m;
    cin >> m;
    while(m--) {
        int a, b;
        cin >> a >> b;
        if(b) {
            if(find(a) == find(b)) continue;
            else {
                size[find(b)] += size[find(a)];
                f[find(a)] = find(b);
            }
        }else if(s == "Q1") {
            int a, b;
            cin >> a >> b;
            cout << (find(a) == find(b) ? "Yes" : "No") << endl;
        }else {
            int a;
            cin >> a;
            cout << size[find(a)] << endl;
        }
    }
}

