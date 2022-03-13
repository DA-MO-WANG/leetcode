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
    int l = 0, r = alls.size() - 1;
    while(l < r) {
        int mid = l + r >> 1;
        if(alls[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return l + 1;//因为后续要使用前缀和，所以返回的坐标要加上1；--s[i] = s[i - 1] + a[i];
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
    alls.erase(unique(alls.begin(),alls.end()),alls.end());


    for(auto item : add) {
        int x = find(item.first);

        a[x] += item.second;
    }

    for(int i = 0; i < alls.size(); i++) {
        s[i] = s[i - 1] + a[i];
    }

    for(auto item : query) {
        int l = item.first;
        int r = item.second;

        cout << s[r] - s[l - 1] << endl;
    }


}