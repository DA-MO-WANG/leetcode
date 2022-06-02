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

int dfs(int x,int c) {
    color[x] = c;
    for (int i = h[x]; i != -1 ; i = ne[i]) {
        int j = e[i];
        if(!color[j]) {
            //相邻层的染色关系
            if(!dfs(j,3 - c)) return false;
        }else if(color[j] == c) return false;//相邻层，染色一致，出现奇数环
    }
    return true;
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
        if(!dfs(i,1)) {
            printf("No");
            break;
        }
    }
    printf("Yes");





}
