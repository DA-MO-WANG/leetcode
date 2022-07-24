//
// Created by rich heart on 24/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 6010;
int n;
//临接表来表示树结构
int h[N], e[N], ne[N], idx;
int happy[N];
//状态表示
int f[N][2];
//找到根节点，职级最大的点-没有父节点的点
bool is_father[N];
//k -> l
void add(int k, int l) {
    e[idx] = l;
    ne[idx] = h[k];
    h[k] = idx;
    is_father[k] = true;
    idx++;
}

void dp(int n) {

}
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> happy[i];
    }
    memset(h,-1, sizeof(h));
    while (--n) {
        int l, k;
        cin >> l >> k;
        add(k,l);
    }
    int root = -1;
    for (int i = 0; i < n; ++i) {
        if(!is_father(i)) root = i,break;
    }
    dp(root);
    cout << max(f[n][0],f[n][1]);
    return 0;
}