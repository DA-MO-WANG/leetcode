//
// Created by rich heart on 07/08/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1010;
int f[N], v[N],g[N];
int main() {
    int count = 0;
    int x;
    while(cin >> x) {
        v[++count] = x;
    }
    for (int i = 1; i <= count; ++i) {
        f[i] = 1;
        for (int j = 1; j < i; ++j) {
            if(v[j] >= v[i]) f[i] = max(f[i],f[j] + 1);
        }
    }
    int res = 0;
    for (int i = 1; i <= count; ++i) {
        res = max(res, f[i]);
    }
    cout << res << endl;
    //g[] 用来维护子序列的尾部元素
    memset(g,0x3f,sizeof g);
    //cnt用来记录g[]中实际有效的子序列的数量
    int cnt = 0;
    for (int i = 1; i <= count; ++i) {
        //k用来枚举g，发现g中比他大的最接近的元素
        //因为g是单调的刻意这么做
        int k = 0;
        //比他>=的最小值所在位置
        while(g[k] < v[i]) k++;
        //选出>=的最小位置，那就替换
        //如果当前g中都比他小，那就赋值，也是这个样子，只不过在合理不是覆盖过去的旧值
        g[k] = v[i];
        //比较枚举最后的位置和g中元素的数量，来判断当是第二种情况时，要增加子序列的数量
        if(k >= cnt) cnt++;
    }
    cout << cnt << endl;
    return 0;
}