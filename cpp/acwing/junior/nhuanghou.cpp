//
// Created by rich heart on 6/3/22.
//


#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
//n皇后
//满足条件：每一行每一列每一斜线不能出现两个皇后
//---------n个位置，各自行，上皇后出现在的列位置，
//皇后放/不放--》映射成0/1
//用深搜，把所有可能都打印一遍

const int N = 10;
int n;
int path[N];
bool str[N];
void dfs(int row) {
    if(row > n) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if(path[i] != j) printf(".");
                else printf("Q");
            }
            printf("\n");
        }
        printf("\n");
        return;
    }

    //遍历的是这个位置上填的数
    for (int j = 1; j <= n; j++) {
        if(!str[j]) {
            path[row] = j;
            str[j] = true;
            dfs(row + 1);
            str[j] = false;
        }
    }
}
int main() {
    scanf("%d",&n);

    dfs(1);

    return 0;


}