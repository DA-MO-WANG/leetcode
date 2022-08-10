//
// Created by rich heart on 10/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 55;
int n;
int q[N];
//dfs求最小步数——方式一：设置全局最小值
int ans;
//这两个数组分别记录，上升序列组中尾部位置、下降序列尾部位置
int up[N], down[N];
//u 记录枚举的位置
//uu 记录的是上升子序列中动态序列个数
//du 记录的是下降子序列中动态序列个数
void dfs(int u, int uu, int du) {
    if(uu + du > n) return;
    if(u == n) {
        ans = uu + du;
        return;
    }

    //递归中的情况
    //选择上升的分支
    int k = 0;
    while(k < uu && up[k] >= q[u]) k++;
    int t = up[k];
    up[k] = q[u];
    //开一个新的上升序列
    if(k > uu) dfs(u + 1, uu + 1, du);
    //加入先有上升序列
    else dfs(u + 1, uu, du);
    //恢复现场
    up[k] = t;

    int m = 0;
    while(m < du && down[m] <= q[u]) m++;
    int r = down[m];
    down[m] = q[u];
    //开一个新的上升序列
    if(m > du) dfs(u + 1, uu, du + 1);
        //加入先有上升序列
    else dfs(u + 1, uu, du);
    //恢复现场
    up[m] = r;
}

int main() {
    //这种写法，包含了0结尾停止，循环了n次
    while (cin >> n, n) {
        for (int i = 0; i < n; ++i) {
            cin >> q[i];
        }
        dfs(0,0,0);
        cout << ans << endl;
    }
    return 0;
}