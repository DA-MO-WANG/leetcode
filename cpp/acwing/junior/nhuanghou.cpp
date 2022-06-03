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


int n;
int path[n + 1];
void dfs(int row) {
    if(row == n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(path[i]) printf(".");
                else printf("")
            }
        }
    }
}
int main() {
    scanf("%d",&n);

    dfs(1);

    return 0;


}