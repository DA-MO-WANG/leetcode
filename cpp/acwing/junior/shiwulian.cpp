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
//如何维护每个节点到根节点的距离？(数学归纳法的本质)
    //d[x] 最开始只能维护当前节点到父节点的距离（直接相连的节点的距离）-初始值是0
    //随着路径压缩，在递归的过程中，完成了每个节点到根节点距离的计算
    //先递归find(p[x]) 这个过程一完成，d[p[x]]也完成了，p[x]这个点到根节点的距离计算（预估完成的）
    //计算当前节点到根节点的距离：d[x] = d[x]（x-x父） + d[p[x]]（x父-根）
    //更新当前节点的父节点 p[x] = 保存的根节点位置
    

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
