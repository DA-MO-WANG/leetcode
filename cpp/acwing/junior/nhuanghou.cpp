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
bool str[N];//记录列占位标志
//记录下斜线编号
bool zxx[2*N + 1],fxx[2*N + 1];
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
        if(!str[j] && zxx[row + j] && fxx[row - j + n]) {
            path[row] = j;
            str[j] = true;
            zxx[row + j] = true;
            fxx[row - j + n] = true;
            dfs(row + 1);
            str[j] = false;
            zxx[row + j] = false;
            fxx[row - j + n] = false;
        }
    }
}
int main() {
    scanf("%d",&n);

    dfs(1);//行肯定不冲突-固定不同行了

    return 0;


}