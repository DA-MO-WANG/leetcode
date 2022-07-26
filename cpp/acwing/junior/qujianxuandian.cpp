//
// Created by rich heart on 26/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
struct Range{
    int l, int r;
    bool operator< (const Range &w)const {
        return r < w.r;
    }
}range[N];
int n;
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int l, r;
        scanf("%d%d",&range[i].l,&range[i].r);
    }
    sort(range,range + n);
    int res = 0, ed = -2e9;
    for (int i = 0; i < n; ++i) {
        if(ed < range[i].l) {
            res ++;
            ed = range[i].r;
        }
    }
    cout << res << endl;
    return 0;
}