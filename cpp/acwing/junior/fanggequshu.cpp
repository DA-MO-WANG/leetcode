//
// Created by rich heart on 02/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int n;
int f[20][20], w[20][20];
void dp() {
    memeset(f, 0 , sizeof(f));
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            if(f[i - 1][j] > f[i][j - 1]) {
                f[i][j] = f[i - 1][j] + w[i][j];
                w[i - 1][j] = 0;
            }else {
                f[i][j] = f[i][j - 1] + w[i][j];
                w[i][j - 1] = 0;
            }
        }
    }
}
int main() {
    cin >> n;
    while (true) {

        int row , col, v;
        cin >> row >> col >> v;
        if(!row || !col) {
            break;
        }
        w[row][col] = v;
    }
    dp();
    int res = f[n][n];
    dp();
    res += f[n][n];
    cout << res << endl;
    return 0;
}