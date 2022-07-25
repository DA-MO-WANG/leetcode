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
int dp(int i, int j) {
    int &v = f[i][j];
    if(v != -1) return v;

    for (int i = 0; i < 4; ++i) {
        int a = i + dx[i], b = j + dy[i];
        if(a && a <= r && b && b <= c && h[i][j] > h[a][b]) {
            f[i][j] = max(f[i][j],dp(a,b) + 1);
        }
    }
    return f[i][j];
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