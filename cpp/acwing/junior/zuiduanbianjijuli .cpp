//
// Created by rich heart on 20/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
const int N = 1010;
int n, m;
//用来记录输入的两个字符串
char a[N],b[N];
//dp结构
//a [1,i] 变成 b [1,j] 的操作方式组成的集合
int f[N][N];
int main() {
    scanf("%d%s",n,a + 1);
    scanf("%d%s",m,b + 1);
    //遍历所有的状态：状态由[1,i]-[1,j]组成
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            //f[i - 1][j] + 1 ==> 删除后匹配的情况
            //f[i][j - 1] + 1 ==> 添了一个数才匹配
            //这里的i并不是指的是原字符串的位置，我们要讨论的是操作方式，而不会真得在i后面添加一个数
            //所以
            f[i][j] = min(f[i - 1][j] + 1, f[i - 1][j - 1] + 1);
            if(a[i] != b[j]) f[i][j] = min(f[i][j], f[i - 1][j - 1] + 1);
        }
    }
    return 0;
}