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
    for (int i = 0; i < n; ++i) {
        int j 
    }
    return 0;
}