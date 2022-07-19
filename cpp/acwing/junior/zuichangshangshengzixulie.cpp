//
// Created by rich heart on 19/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
const int N = 1010;
int n;
int v[N];
//dp结构的容量取决于状态的数目
//状态的数目取决于分类点的选择
//这里的分类点是倒数第二个位置---倒数第二个位置的选择区间是[0,i-1]
int f[N];
int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> v[i];
        //cout << v[i] << " ";
    }

    //第一层循环遍历的是结尾的情况
    for (int j = 1; j <= n; ++j) {
        //第二层循环遍历的是倒数第二个位置的情况
        //每换一种集合，集合中的第一个初始情况都是这个序列第二位置没有，只有本身一个数的情况，这是下面情况的出发点
        f[j] = 1;
        for (int i = 1; i < j ; ++i) {
            //根据必要条件，只去算符合严格上升的限制的情况
            if(v[i] < v[j]) f[j] = max(f[j],f[i] + 1);
        }
    }
    int res = 0;
    for (int k = 1; k <= n; ++k) {
        res = max(res,f[k]);
    }
    cout << res <<endl;
    return 0;
}