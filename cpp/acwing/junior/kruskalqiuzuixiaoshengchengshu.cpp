//
// Created by rich heart on 6/1/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>


using namespace std;

//稀疏图——》最小生成树——》kruskal
const int M = 2e5 + 10;
int n,m;
int q[N];
struct Edge{
    int u,v,w;
    //重写运载符<
    bool operator< (const Edge &W)const {
        return w < W.w;
    }
}edges[M];

//写并查集的find方法
int find(int x) {

    int f = p[x];
    if(f == x) return x;
    return find(f);
}
void combine(int a, int b) {
    int fa = find(a);
    int fb = find(b);
    p[fa] = fb;
}
int main() {
    scanf("%d%d",&n,&m);
    //准备用结构体数组来存边
    for (int i = 0; i < m ; ++i) {
        int u,v,w;
        scanf("%d%d%d",&u,&v,&w);
        edges[i] = {u,v,w};
    }
    //准备并查集部分,初始化
    for (int k = 1; k <= n; ++k) {
        q[k] = k;
    }
    int res = 0, cnt = 0;
    //第一步：把边权重升序排列
    sort(edges);
    //第二步：枚举
    for (int j = 0; j < m; ++j) {
        int u = edges[j].u, v = edges[j].v, w = edges.w;
        if(find(u) != find(v)) {
            res += w;
            cnt++;
            combine(u,v);
        }
    }
    if(cnt < m) {
        printf("impossible");
    }els






}

