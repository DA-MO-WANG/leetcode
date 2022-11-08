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
//这个黑盒就是处理快排的过程
void quick_sort(int left, int right) {
    //因为quicksort 核心是分治
    //分治的前提——》要明确分界点x，一部分变成两部分
    //分界点归位——》左面部分处理成 <=x , 右面部分处理成 >=x
    //把两部分分别排序
    if(left <= 0 || left >= n) {
        return;
    }
    int partition = left + right >> 2;
    quick_sort(left,partition - 1);
    quick_sort(partition + 1, right);

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