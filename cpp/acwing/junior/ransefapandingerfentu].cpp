//
// Created by rich heart on 6/2/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>

using namespace std;
const int N = 1e5 + 10, M = 1e5 + 10;
int h[N],e[M],ne[M],idx;
int n, m;
int color[N];//颜色数组
//无向图——判断二分图——染色法
void add(int a, int b) {
    //头插法
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx;
    idx++;
}
int main() {
    //保存图结构
    //因为染色法采用dfs, 借助出边——》用邻接矩阵来描述边
    memset(h,-1,sizeof h);
    while (m--) {
        int u,v;
        scanf("%d%d",&u,&v);
        //无向图——》双向边都要准备
        add(u,v),add(v,u);
    }

    for(int i = 1; i<= n; i++) {
        //dfs也是一层一层走，只不过是单条路径一层层
        if(!dfs(i,1)) 





    }





}
