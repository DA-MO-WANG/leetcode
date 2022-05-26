//
// Created by rich heart on 5/26/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>
#include <queue>

using namespace std;
//n点是10万级，On方要爆了，考虑用堆优化方法
//而且属于稀疏图，就考虑用邻接矩阵来表达边关系
const int N = 2e5 + 10;
typedef pair<int,int> PII;
int h[N],e[N],w[N],ne[N],idx;
int dis[N];
int n , m;
void add(int x, int y, int z) {
    if(x == y) return;
    e[idx] = y;
    w[idx] = z;
    ne[idx] = h[x];
    idx++;
}

int dijkstra() {
    memset(dis,0x3f,sizeof dis);
    dis[1] = 0;

    priority_queue<PII,vector<PII>,greater<PII>> heap;
    heap.push
}
int main() {
    cin >> n >> m;
    memset(h,-1,sizeof h);
    while(m--) {
        int x, y, z;
        cin >> x >> y >> z;
        add(x,y,z);
    }
    int res = dijkstra();
    cout << res;


}
