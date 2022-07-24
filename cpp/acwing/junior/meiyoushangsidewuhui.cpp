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
    idx++;
}

void dp(int u) {
    f[u][1] = happy[u];
    for (int i = h[u]; i != -1; i = ne[i]) {
        int s = e[i];
        //先把要依赖的上一个状态记录下来
        dp(s);
        f[u][0] += max(f[s][1],f[s][0]);
        f[u][1] += f[s][0];
    }
}
int main() {
    cin >> n;
    //节点编号从1开始
    for (int i = 1; i <= n; ++i) {
        cin >> happy[i];
    }
    memset(h,-1, sizeof(h));
    for(int i = 0; i < n -1; i++) {
        int l, k;
        cin >> l >> k;
        //标记的是有父节点的
        is_father[l] = true;
        add(k,l);
    }
    //打印邻接矩阵的元件
    //cout << is_father[2] << endl;
    // for(int i=1;i<=n;i++)
    // {
    //     cout<<i<<":";
    //     for(int j=h[i];j!=-1;j=ne[j])
    //     {
    //         cout<<"->"<<e[j];
    //     }
    //     cout<<endl;
    // }
    int root = 1;
    while(is_father[root]) root++;
    //cout << root ;
    dp(root);
    cout << max(f[root][0],f[root][1]);
    return 0;
}