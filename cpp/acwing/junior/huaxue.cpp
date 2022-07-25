//
// Created by rich heart on 25/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 310;
int f[N][N], h[N][N];
int r, c;
int dx[4] = {-1,0,1,0}, dy[4] = {0,-1,0,1};
int dp(int row, int col) {
    int &v = f[row][col];
    if(v != -1) return v;
    //每次换新起点，都要重新计算长度
    v = 1;
    for (int i = 0; i < 4; ++i) {
        int a = row + dx[i], b = col + dy[i];
        if(a && a <= r && b && b <= c && h[row][col] > h[a][b]) {
            f[row][col] = max(f[row][col],dp(a,b) + 1);
        }
    }
    return f[row][col];
}
int main() {
    cin >> r >> c;
    for (int i = 1; i <= r; ++i) {
        for (int j = 1; j <= c; ++j) {
            cin >> h[i][j];
        }
    }
    memset(f,-1, sizeof(f));
    int res = 0;
    for (int i = 1; i <= r; ++i) {
        for (int j = 1; j <= c; ++j) {
            res = max(res,dp(i,j));
        }
    }
    cout << res << endl;
    return 0;
}