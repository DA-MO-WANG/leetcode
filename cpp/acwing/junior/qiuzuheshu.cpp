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
            // c[0][1]这种视为0，不参与计算，不合法的组合数，不处理就是0
            else c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
        }
    }
}
int main() {
    init();
    cin >> n;
    while(n--) {
        int a, b;
        scanf("%d%d",&a,&b);
        printf("%d\n",c[a][b]);
    }
    return 0;
}