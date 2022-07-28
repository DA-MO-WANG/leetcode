//
// Created by rich heart on 28/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
struct Range{
    int l;
    int r;
    bool operator< (const Range &w)const  {
        return l < w.l;
    }
}range[N];
int s, t;
int n;
int main() {
    cin >> s >> t;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int l, r;
        cin >> l >> r;
        range[i] = {l, r};
    }
    sort(range,range + n);
    int res = 0;
    int start = s;
    for (int i = 0; i < n; i++) {
        int j = i;
        //覆盖这个点：range[i].l < start
        while(range[i].l < start) {
            //找到覆盖这个点的区间右端点最大的区间
            j = max(j,range[i].r);
        }
        start = j;
        res++;
        if(start >= t) break;
    }
    return 0;
}