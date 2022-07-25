//
// Created by rich heart on 25/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 310;
int f[N][N], a[N][N];
int r, c;

int main() {
    cin >> r >> c;
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            cin >> a[i][j];
        }
    }


    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            if(!i && !j) {
                f[0][0] = 1;
                continue;
            }
            if(i >= 1 && a[i][j] > a[i -1][j]) f[i][j] = max(f[i][j],f[i - 1][j]);
            else if(i + 1 < r && a[i + 1][j] < a[i][j]) f[i][j] = max(f[i][j],f[i + 1][j]);
            else if(j - 1 >= 0 && a[i][j - 1] < a[i][j]) f[i][j] = max(f[i][j],f[i][j - 1]);
            else if(j + 1 < c && a[i][j + 1] < a[i][j]) f[i][j] = max(f[i][j],f[i][j + 1]);
        }
    }
    cout << f[r - 1][c - 1] << endl;
    return 0;
}