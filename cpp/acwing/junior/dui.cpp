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
bool checkMaxHeap(int x) {

    int max = x;
    int lc =  2 * x, rc = 2 * x + 1;
    if(lc <= n && v[x] < v[lc]) max = lc;
    if(rc <= n && v[max] < v[rc]) max = rc;
    if(max != x) {
        swap(v[max],v[x]);
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
//前、后、中，都是基于dfs，类似栈过程
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
