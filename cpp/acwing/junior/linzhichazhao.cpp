//
// Created by rich heart on 04/07/2022.
//
//y总思路:利用链表来做
//审题意
//对于每一个数，找到他左边范围中与他值距离最近的距离，及对应数的下标
//因为结果中要下标——》保存原来的值与下标的绑定关系——》pair队
//因为左边范围，所以倒着算，可以利用排序
//排序又不能破坏原来的下标——》pair
//应为保存了下标，所以排序后，从下标为原n的开始算，这个节点两边的都是在他原序列左边的
//n算完后，接着算原n-1，但为了只计算原左边的，所以删除n这个节点，以此类推，直到做到2


//如何构建一个链表了：双向链表-可以拿到前驱后继
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
const int N = 10010;
typedef long long ll;
typedef pair<ll,int> pii;//保存每个位置上的数据和位置信息
pii a[N];//保存输入的数据和位置信息
int p[N];//维护的是原序列的位置关系到模拟链表的数组索引的映射关系
int l[N], r[N];//记录的是模拟链表的数组的唯一标识的前驱、后继标识
pii ans[N];//记录结果
int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i].first;
        a[i].second = i;
    }

    //排序处理——》方便找到距离最接近他的
    sort(a + 1,a + 1 + n);//[)
    //构造双向链表
    //for的条件是模拟链表的数组和原序列共用的

    //构造哨兵:保证哨兵和相邻距离不会成为答案，也就是永远不会成为最小的情况
    a[0].first = 3e9, a[n + 1].first = -3e9;
    for(int i = 1; i <= n; i++) {
        l[i] = i - 1, r[i] = i + 1;
        p[a[i].second] = i;
    }
    //这里是倒着遍历原序列的位置，从n开始处理，方便保证左向范围
    for(int i = n; i > 1; i--) {
        int j = p[i], left = l[j], right = r[j];
        int lv = abs(a[j].first - a[left].first);
        int rv = abs(a[right].first - a[j]);
        if(lv <= rv) ans[i] = {lv,a[left].second};
        else ans[i] = {rv,a[right].second};
    }
    for (int i = 2; i <= n; i++) {
        cout << ans[i].first << " "<< ans[i].second<<endl;
    }
    return 0;
}