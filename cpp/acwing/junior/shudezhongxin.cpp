//
// Created by rich heart on 5/22/22.
//
#include <cstring>
#include <algorithm>
#include <iostream>

using namespace std;
const int N = 1e5 + 10, M = 2 * N;
int n;
//一开始默认最大值的最小值是所有节点数量，然后让这个初始状态去和流程中的每一个候选人比较，留下较小的
int ans;
//有向图的dfs模型
//第一层：找到把一个点删除后，连通块中的最大值——》各个连通块中的节点数量
//第二层：对应每一个被删除的点，对应连通块最大节点数量的最小值

//要解决第一个问题：绕不开每个节点对应树的节点数量——》dfs过程可以计算

//无向图-临接表结构
//临接表类似hash的结构
//要维护一个单链表结构
int h[N],e[M],ne[M],idx;
bool str[N];
void add(int a, int b) {
    //a,b都指的是节点编号
    //组装好单链表一个节点
    e[idx] = b;

    ne[idx] = h[a];
    h[a] = idx;
    idx++;
}

int dfs(int u) {
    //沿着每个节点上维护的连通编号单链表来往下走
    //h[]存储的是当前节点对应链表的头节点的唯一标识;ne[]存储的是链表上当前节点的下一个节点


    str[u] = true;
    //res 维护当前节点的连通块节点的数量
    int sum = 1, res = 0;
    for (int i = h[u]; e[i]; i= ne[i]) {
        //链表中的节点是否访问过
        if(!str[e[i]]) {
            int s = dfs(e[i]);
            res = max(res,s);
            sum += s;
        }

    }
    res = max(res, n - sum);
    ans = min(ans,res);
    return sum;


}
int main() {
    cin >> n;
    //默认无向图中每个节点都是孤立的
    ans = n;
    memset(h,-1,sizeof h);
    int m = n - 1;
    while(m--) {
        int a, b;
        cin >> a >> b;
        add(a,b);
    }
    cout << ans;

}
