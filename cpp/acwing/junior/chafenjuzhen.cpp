//
// Created by rich heart on 3/6/22.
//
#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;
const int N = 1010;
int a[N][N], b[N][N];
void insert(int x1, int y1, int x2, int y2, int c) {
    b[x1][y1] += c;
    b[x1][y2 + 1] -= c;
    b[x2 + 1][y1] -= c;
    b[x2 + 1][y2 + 1] += c;
}
int add(int x1, int y1) {
    for(int i = 1; i <= x1; i++) {
        for(int j = 1; j <= y1; j++) {
            b[x1][y1] += b[i][j];
        }
    }
    return b[x1][y1];
}
int main() {
    int n, m , q;
    cin >> n >> m >>q;

    for(int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; ++j) {
            scanf("%d",&a[i][j]);
        }
    }
    //构造这个形态的差分矩阵
    for(int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; ++j) {
            insert(i,j,i,j,a[i][j]);
        }
    }
    while(q--) {
        int x1, y1, x2, y2, c;
        cin >> x1 >> y1 >> x2 >> y2 >> c;
        insert(x1,y1,x2,y2,c);
    }
    for(int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; ++j) {
            b[i][j] = add(i,j);
        }
    }
    for(int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; ++j) {
            cout << b[i][j] << " ";
        }
    }
    return 0;
}