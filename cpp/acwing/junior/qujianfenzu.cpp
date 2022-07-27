//
// Created by rich heart on 27/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
struct Range{
    int l;
    int r;
    bool operator< (const Range &w)const {
        return l < w.l;
    }
}range[N];
int n;
int main() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int l,r;
        cin >> l >> r;
        range[i] = {l,r};
    }
    int res = 0;
    int min_ed = -2e9;
    for (int i = 0; i < n; ++i) {
        if(range[i].l > min_ed) {
            res++;
        }
        min_ed = max(min_ed, range[i].r);
    }
    cout << res << endl;
    return 0;
}