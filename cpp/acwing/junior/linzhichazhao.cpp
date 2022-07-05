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
int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i].first;
        a[i].second = i;
    }
    return 0;
}