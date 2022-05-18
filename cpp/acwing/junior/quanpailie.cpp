//
// Created by rich heart on 5/18/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
const int N = 10;
//dfs典型：一路走到黑，无路可走，再回退，再尝试

//dfs保存的是一条路径==>用来记录路径的结构
int path[N];
bool fg[N];
int n;
//u代表遍历的层数--代表顺序的位置
void dfs(int u) {
    //无路可走--意味着一条路径完整了，可以打印了
    if(u == n) {
        //u的位置和path的下标对齐
        for (int i = 0; i < n; ++i) {
            cout << path[i] << " ";
        }
        cout << endl;
        return ;
    }

    //确定位置的过程,在当前位置填数的过程
    //记录选择的结构-排除已经用过的结构
    for(int num = 1; num <= n; num++) {
        if(!fg[num]) {
            //在路径结构中记录当前位置选择的数
            path[u] = num;
            fg[num] = true;
            dfs(u+1);
            //为当前u的下一个选择，恢复现场，恢复到当前u最开始的状态
            fg[num] = false;
        }
    }
}
int main() {
    cin >> n;
    dfs(0);
    return 0;
}
