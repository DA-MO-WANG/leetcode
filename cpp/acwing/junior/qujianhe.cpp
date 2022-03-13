//
// Created by rich heart on 3/13/22.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
const int N = 30010;
int a[N],s[N];
vector<int> alls;
typedef pair<int,int> pii;
vector<pii> add, query;
int n, m;
int find(int x) {
    int l = 0,
}
int main() {
    cin >> n >> m;

    while(n--) {
        int x, c;
        cin >> x >> c;
        add.push_back({x,c});
        alls.push_back(x);
    }
    while(m--) {
        int l, r;
        cin >> l >> r;
        query.push_back({l,r});
        alls.push_back(l);
        alls.push_back(r);
    }

    sort(alls.begin(),alls.end());
    e
}