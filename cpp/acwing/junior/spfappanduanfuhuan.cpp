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
int dis[N];
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
    mem
}
int main() {
    cin >> n >> m;
    while(m--) {
        int x, y ,z;
        cin >> x >> y >> z;
        add(x,y,z);
    }



}
