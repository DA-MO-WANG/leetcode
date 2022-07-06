//
// Created by rich heart on 5/7/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
int f[N],sz[N];
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
        sz[i] = 1;
    }
    //总操作数
    int m;
    cin >> m;
    while(m--) {
        int a, b;
        cin >> a >> b;

        if(b && a != b) {
            if(find(a) == find(b)) continue;
            else {
                sz[find(b)] += sz[find(a)];
                f[find(a)] = find(b);
            }
        }else if(!b) {
           //a取消跟随b==》a跟随自己
            sz[find(b)] -= sz[find(a)];
            f[find(a)] = a;
        }
    }
    int max = 0;
    for(int i = 1; i <= n; i++) {
        max = max(max,sz[find(i)])
    }
    cout << max;
}

