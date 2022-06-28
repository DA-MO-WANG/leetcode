//
// Created by rich heart on 28/06/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
int n;
int exgcd(int a, int b, int &x, int &y) {
    if(!b) {
        x = 1, y = 0;
        return a;
    }
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