//
// Created by rich heart on 08/11/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
//理解完题意后，接下来先关注处理中间过程之前，输入部分
//处理完中间过程之后，要关注输出什么
const int N = 1e9 + 10;
int q[N];
int n;
//骨架
void quick_sort(int left, int right) {
    //递归基
    if(left >= right) {
        return;
    }
    //拿到分界点位置
    int partition = partition(left, right);
    //递归处理三部分中的两侧
    quick_sort(left,partition - 1);
    quick_sort(partition + 1, right);

}
int partition(int left, int right) {
    int pivot = left + right >> 1;
    //设计两个辅助指针
    int i = 0 j = 0;
    

}
int main() {
    //把要输入的数据存放到一个自己控制的结构中
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> q[i];
    }
    quick_sort(0,n - 1);
    return 0;
}