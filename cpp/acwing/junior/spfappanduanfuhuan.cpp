//
// Created by rich heart on 5/28/22.
//
#include <algorithm>
#include <iostream>
#include <cstring>
#include <queue>

using namespace std;
const int N = 2010, M = 10010;
int h[N],e[N],w[N],ne[N],idx;
int dis[N],cnt[N];
bool str[N];
int n,m;
void add(int x, int y, int z) {
    e[idx] = y;
    ne[idx] = h[x];
    w[idx] = z;
    h[x] = idx;
    idx++;
}

int spfa() {
    memset(dis,0x3f,sizeof dis);
    dis[1] = 0;
    queue<int> queue;
    for (int i = 1; i <= n; ++i) {
        queue.push(i);
        str[i] = true;
    }
    int t = queue.front();
    queue.pop();
    str[t] = false;
    for (int j = h[t]; j != -1; j = ne[j]) {
        int k = e[j];
        if(dis[k] > dis[t] + w[j]) {
            dis[k] = dis[t] + w[j];
            cnt[k] = cnt[t] + 1;
            if(cnt[k] == n) return 1;
            if(!str[k]) {
                queue.push(k);
                str[k] = true;
            }
        }
    }

    return 0;
}
int main() {
    cin >> n >> m;
    while(m--) {
        int x, y ,z;
        cin >> x >> y >> z;
        add(x,y,z);
    }
    int res = spfa();
    if(res) cout << "Yes";
    else cout << "No";


}
