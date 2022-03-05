//
// Created by rich heart on 3/5/22.
//

#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int a[N], b[N];
void insert(int l, int r, int c) {
    b[l] += c;
    b[r + 1] += c;
}
int main() {
    int n, m;
    cin >> n >> m;

    for(int i = 1; i <= n; i++) {
        scanf("%d",&a[i]);
        insert(i,i,a[i]);
    }


    return 0;
}

