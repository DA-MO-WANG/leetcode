//
// Created by rich heart on 5/28/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 1e5 + 10;
int n, m;
//n,m的关系，是1：1，稀疏图——》边的关系就用邻接矩阵来表达

//邻接矩阵的结构设计
//e数组容量，和m有关，这里m:n是1:1,所以可以用n表示
int h[N], e[N],w[N],ne[N],idx;
int dis[N];
bool str[N];
//手写队列表示
int q[N];
//构造边
void add(int x, int y, int z) {
    e[idx] = y;
    ne[idx] = h[x];
    w[idx] = z;
    h[x] = idx;
    idx++;
}

int spfa() {
    int hh = 0, tt = -1;
    q[++tt] = 1;
    memset(dis,0x3f,sizeof dis);
    dis[1] = 0;
    //入队的是另类的，true
    str[1] = true;
    while(hh <= tt) {
        //取出元素同时完成出队操作
        int t = q[hh++];
        str[t] = false;
        for (int i = h[t]; i != -1; i = ne[i]) {
            int j = e[i];
            if(dis[j] > dis[t] + w[i]) {
                dis[j] = dis[t] + w[i];
                if(!str[j]) {
                    q[++tt] = j;
                    str[j] = true;
                }

            }
        }
    }
    if(dis[n] == 0x3f3f3f3f) cout << 0x3f3f3f3f;
    else dis[n];
    //spfa的独特性在用队列维护的是d[基准点]变小的点
}
int main() {
    cin >> n >> m;
    memset(h,-1,sizeof h);
    while(m--) {
        int x, y ,z;
        cin >> x >> y >> z;
        add(x,y,z);
    }

    int res = spfa();
    if(res == 0x3f3f3f3f) cout << "impossible";
    else cout << dis[n];

}