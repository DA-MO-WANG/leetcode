//
// Created by rich heart on 6/3/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>


using namespace std;
const int N = 510, M = 1e5 + 10;
int h[N],e[M],ne[M],idx;
int match[N];
bool str[N];
int n1, n2, m;
void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx;
    idx++;
}
//询问男生x能否找到女生
int find(int x) {
    for(int i   = h[x]; i != -1; i = ne[i]) {
        int j = e[i];
        if(!str[j]) {//一个男生，不用对同一个女生考虑多次，对一个女生只考虑一次
            str[j] = true;
            if(mathc[j] == 0 || find(mathc[j])) {
                mathc[j] = x;//更新匹配
                return true;
            }
        }

    }
    return false;
}
int main() {
    scanf("%d%d%d",&n1,&n2,&m);
    memset(h,-1,sizeof h);
    while(m--) {
        int u, v;
        scanf("%d%d",&u,&v);
        add(u,v);//求的是匹配，匹配概念和顺序无关——》不用在在意是否是有向、无向
    }
    int res = 0;//记录匹配数量

    for(int i = 1; i <= n1; i++) {
        //每次新的男生寻找女生时，都是可以被考虑
        memset(str,false ,sizeof str);
        if(find(i)) res++;
    }
    printf(res);
    return 0;





}
