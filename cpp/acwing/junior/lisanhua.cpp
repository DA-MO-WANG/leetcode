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


//稀疏数轴，因为涉及范围很大，为了避免开一个很大的数组，
//就通过映射，把大index映射成连续的小index---映射规则就是相对次序
//因为处理的是相关位置，其他位置不受影响
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>

using namespace std;
//定义了一个pair对
typedef pair<int,int> pII;
const int N = 300010;
//n次操作、m次询问
int n, m;
int a[N], s[N];
//alls存储的是原序列
vector<int> alls;
vector<pII> add, query;
//找到x对应的序列的相对次序-下标
int find(int x) {
    int l = 0, r = alls.size() - 1;
    while(l < r) {
        int mid = l + r >> 1;
        if(alls[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return r + 1;
}

vector<int> :: iterator unique(vector<int> &a) {
    int j = 0;
    for(int i = 0; i < a.size(); i++) {
        if(!i || a[i] != a[i - 1]) {
            a[j++] = a[i];
        }
    }
    return a.begin() + j;
}

int main() {
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        int x, c;
        cin >> x >> c;
        add.push_back({x, c});
        //离散化的是涉及的数组下标
        alls.push_back(x);

    }

    for(int i = 0; i < m; i++) {
        int l, r;
        cin >> l >> r;
        //存储的是要查询的区间
        query.push_back({l,r});

        alls.push_back(l);
        alls.push_back(r);

    }
    sort(alls.begin(),alls.end());
    alls.erase(unique(alls.begin(),alls.end()),alls.end());


    for(auto item : add) {
        int x = find(item.first);
        //在离散化的数组中放值
        a[x] += item.second;
    }

    for(int i = 1; i < alls.size(); i++) {
        s[i] = s[i - 1] + a[i];
    }



    for(auto item : add) {
        //处理的是初始化位置和值的信息
        int l = find(item.first), r = find(item.second);
        cout << s[r] - s[l - 1] << endl;

    }
    return 0;
}