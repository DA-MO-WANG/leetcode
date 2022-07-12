//
// Created by rich heart on 12/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 10010, M = 110;
int m, n;
//用来记录选法集合
int s[M];
//用来记录单堆在选法集合下的有向无环图所有节点的sg值
int f[N];
int sg(int x) {
    //以前算过，就直接返回
    if(f[x] != -1) return f[x];
    //用来记录后继状态的sg值
    unordered_set<int> ss;
    for (int i = 0; i < m; ++i) {
        int sum = s[i];
        //原料得比选法大，才记录
        if(x >= sum) ss.insert(sg(x - sum));
    }
    //用来计算当前x下的sg值：不在后继状态集合中的最小非负整数
    //枚举结果值
    for (int i = 0; ; ++i) {
        //如果在当前的后继去重集合中找不到这个数
        //而i又是从小往大找的，所以，只要不存在就一定是最小的
        if(!ss.count(i)) return f[x] = i;//只要最小的，也就是第一次
    }
}
int main() {
    cin >> m;
    for (int i = 0; i < m; ++i) cin >> s[i];
    //记录最后异或运算的结果
    cin >> n;
    int res = 0;
    memset(f,-1, sizeof(f));
    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;
        res *= sg(x);
    }
    if(res) cout << "Yes";
    else cout << "No";
    return 0;
}