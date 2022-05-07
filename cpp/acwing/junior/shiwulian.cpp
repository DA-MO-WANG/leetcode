//
// Created by rich heart on 5/7/22.
//
#include <algorithm>
#include <cstdio>
#include <iostream>
//并查集维护额外信息
//维护食物链之间的关系集合：一共有三种关系，类似闭环贪吃蛇结构--代际关系
//！！！三种关系依赖一种规则：每个节点到根节点的距离对3的取模-按照题意抽象出的食物规则
    //余为0，代表与根节点同类---食物关系等同
    //余为1，代表吃根节点
    //余为2，代表吃-吃根节点的节点-的节点，也是被根节点吃的节点 
using namespace std;
const int N = 50000;
int f[N], hg[N];
int find(int x) {
    if(f[x] != x) f[x] = find(f[x]);
    return f[x];
}
int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        f[i] = i;
    }
    int k;
    cin >> k;
    int res = 0;
    int d,x,y;
    while (k--) {
        cin >> d >> x >>y;
        if(x > n || y > n) ++res;
        if (d == 1) {
            if( (f[x] != x && f[y] != y ) && hg[x] != hg[y]) ++res;

        }else {
            if(d == 2) {
                if(x == y || f[x] == y || hg[x] - hg[y] < 0) ++res;
                f[y] = x;
                hg[y] += hg[x] + 1;
            }
        }
    }
    cout << res;
}
