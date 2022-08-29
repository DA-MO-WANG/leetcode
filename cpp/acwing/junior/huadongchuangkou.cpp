//
// Created by rich heart on 5/3/22.
//

#include <iostream>
#include <algorithm>
#include <cstring>
#include <cstdio>

using namespace std;
const int N = 1e6 + 10;

int e[N], q[N];
int main() {

    int n,k;
    cin >> n >> k;
    int hh = 0, tt = -1;
    //循环指针i，代表窗口的右边界，窗口右端变化区间：[k - 1, n]
    for (int i = 0; i < n; ++i) {
        cin >> e[i];

        //对队列的队头限制，因为窗口在变化，队列也要响应来保持双端不越界
        // i - k + 1是理论窗口的最左边界
        //队列记录的是元素的索引
        //hh <= tt ： 保证队列不为空
        if(hh <= tt && i - k + 1 > q[hh]) hh++;
        //特殊的插入逻辑，维护了队列的单调性
        //及时剔除没用的数据 ==》最值固定维护在队头位置（前者的动作导致了后者的效果）
        while(hh <= tt && e[q[tt]] >= e[i]) tt--;
        //在比新人还贴近最值的数前停下脚步，在它前面安家
        q[++tt] = i;
        //每一个窗口态，必然对应一个结果态 ==》
        //这里的判断条件只是规定了输出时机的起点
        //放在最后的位置，表明每一个处理流程的最后都会执行一次
        if(i >= k - 1) cout << e[q[hh]] << " ";
    }
    cout << endl;
    // 重置队列
    hh = 0, tt = -1;
    for (int i = 0; i < n; ++i) {
        //保持队列和窗口范围的一直
        if(hh <= tt && i - k + 1 > q[hh]) hh++;
        while(hh <= tt && e[q[tt]] <= e[i]) tt--;
        q[++tt] = i;
        if(i >= k - 1) cout << e[q[hh]] << " ";
    }



}
