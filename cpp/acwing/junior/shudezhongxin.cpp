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
int ans = n;
//有向图的dfs模型
//第一层：找到把一个点删除后，连通块中的最大值——》各个连通块中的节点数量
//第二层：对应每一个被删除的点，对应连通块最大节点数量的最小值

//要解决第一个问题：绕不开每个节点对应树的节点数量——》dfs过程可以计算

//无向图-临接表结构
//临接表类似hash的结构
//要维护一个单链表结构
int h[N],e[M],ne[M],idx;
void add(int a, int b) {
    //a,b都指的是节点编号
}
int main() {
    cin >> n;
    int m = n - 1;
    while(m--) {
        int a, b;
        cin >> a >> b;
        add(a,b);
    }
    cout << ans;

}
