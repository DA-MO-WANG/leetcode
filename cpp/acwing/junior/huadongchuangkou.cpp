//
// Created by rich heart on 5/3/22.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <cstdio>

using namespace std;
const int N = 1e5 + 10;
//模拟队列的数组，队列是靠hh 和 tt控制的，和模拟用的数组的容量没关系
int e[N], q[N];
int main() {

    int n,k;
    cin >> n >> k;
    int hh = 0, tt = -1;
    for (int i = 0; i < n; ++i) {
        cin >> e[i];

        //保持队列和窗口范围的一致
        if(hh <= tt && i - k + 1 > q[hh]) hh++;
        //hh <= tt ： 保证队列不为空
        //e[q[tt]] >= e[i] : 新添加的元素如果比队尾还小，就把原队尾出队
        //通过相邻元素的比较添加，控制了队列的单调递增性
        while(hh <= tt && e[q[tt]] >= e[i]) tt--;
        q[++tt] = i;//更新一下
        if(i >= k - 1) cout << e[q[hh]] << " ";//打印输出，这个i位置下窗口的最小值
    }
    cout << endl;
    hh = 0, tt = -1;
    for (int i = 0; i < n; ++i) {
        //保持队列和窗口范围的一直
        if(hh <= tt && i - k + 1 > q[hh]) hh++;
        while(hh <= tt && e[q[tt]] <= e[i]) tt--;
        q[++tt] = i;
        if(i >= k - 1) cout << e[q[hh]] << " ";
    }



}
