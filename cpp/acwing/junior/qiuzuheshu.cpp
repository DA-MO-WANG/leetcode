//
// Created by rich heart on 06/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 2010;
int c[N][N];
int n;
void init() {
    for (int i = 1; i < N; i++) {
        //j < i===>来实现 c a b ，组合数的一个约束
        for(int j = 0; j <= i; j++) {
            if(!j) c[i][j] = 1;
            else c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
        }
    }
}
int main() {
    init();
    return 0;
}