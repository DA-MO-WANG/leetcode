//
// Created by rich heart on 28/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int n;
//返回最大公约数
int exgcd(int a, int b, int &x, int &y) {
    //递归基条件
    if(!b) {
        x = 1, y = 0;
        return a;
    }
    //y x 倒过来填放，方便后续计算
    int d = exgcd(b, a % b, y , x);
    y = y - a / b * x;
    return d;
}
int main() {
    cin >> n;
    while(n--) {
        int a, b, x, y;
        scanf("%d%d",&a,&b);
        exgcd(a,b,x,y);
        printf("%d%d\n",x,y);
    }
    return 0;
}