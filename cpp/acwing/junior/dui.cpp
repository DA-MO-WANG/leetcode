//
// Created by rich heart on 5/29/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>
#include <stack>

using namespace std;
const int N = 1010, M = 110;
int m, n;
int v[N];
//检查堆，主要是否维护了堆相对于二叉树的多出来的定义
//主要涉及了下沉过程（基于dfs，一扎到底的过程）
bool checkMaxHeap(int x) {

    int max = x;
    int lc =  2 * x, rc = 2 * x + 1;
    //判断三个点的最大值，只用两次比较
    //比较顺序，从最小的情况开始
    if(lc <= n && v[x] < v[lc]) max = lc;
    if(rc <= n && v[max] < v[rc]) max = rc;
    if(max != x) {
        //凡是判断逻辑的，不能更改原数据的结构
        //这里跟下沉过程还是有点区别的
        //swap(v[max],v[x]);
        return false;
    }else {
        return checkMaxHeap(lc) && checkMaxHeap(rc);
    }


}
bool checkMinHeap(int x) {

    int min = x;
    int lc =  2 * x, rc = 2 * x + 1;
    if(lc <= n && v[x] > v[lc]) min = lc;
    if(rc <= n && v[min] > v[rc]) min = rc;
    if(min != x) {
        swap(v[min],v[x]);
        return false;
    }else {
        return checkMinHeap(lc) && checkMinHeap(rc);
    }


}
//所谓后序遍历、中序遍历，和是什么堆没关系，只根他的二叉树结构有关
//前、后、中，都是基于dfs，类似栈过程--利用递归模拟栈实现
//!!常忘记递归终止条件——扎到底的时机，最后一层的递归调用代码的执行完毕
void printPost(int x) {
    if(x > n) return;
    int lc =  2 * x, rc = 2 * x + 1;
    printPost(lc);
    printPost(rc);
    cout << v[x] << " ";

}
int main() {
    cin >> m >> n;
    for (int j = 0; j < m; ++j) {
        for (int i = 1; i <= n; ++i) {
            scanf("%d",v[i]);
        }
        //判断是不是大根堆、小根堆、不是堆
        bool resMax = checkMaxHeap(1);
        bool resMin = checkMinHeap(1);
        if(resMax) cout << "MaxHeap" << endl;
        else if(resMin) cout << "MinHeap" << endl;
        else cout << "NotHeap" << endl;

        //打印他的后序遍历
        printPost(1);
        cout << endl;

    }




}
