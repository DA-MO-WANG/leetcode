//
// Created by rich heart on 3/9/22.
//

//知识点：离散化：整数的离散化a[]
//=》值的范围很大的数，为了实现利用值做下标，把它映射成0-n-1的连续范围
//值的范围（影响开的数组的范围）如果不大，可以用前缀和--本质就是预处理，开一个数组
//注意的问题：
// a中有重复元素——》联系知识点：去重
// 如何算出a[i]中离散化后的值——》联系知识点：二分


//unique(开始迭代器，结束迭代器)=》它会把不重复的元素放到前面，重复的放到后面，返回最后一个不重复的值
//erase(开始迭代器，结束迭代器)=》删除这个区间的部分

//前提：这个原数列是有序的，但其中的值跨越的范围很大---把他们映射成连续的小区间
//求一个数x在连续数组中的对应下标---》实际就是二分，最终他这个值映射成相对位序

#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;
typedef pair<int,int> pII;
const int N = 300010;
int n, m;
int a[N], s[N];

vector<int> alls;
vector<pII> add, query;

int find(int x) {
    int l = 0, r = alls.size() - 1;
    while(l < r) {
        int mid = l + r >> 1;
        if(alls[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return r + 1;
}

int main() {
    
    return 0;
}