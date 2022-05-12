//
// Created by rich heart on 5/12/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;
//这里槽的容量，最好是质数，因为影响所选择的哈希函数的哈希冲突概率
const int N = 1e5 + 3;
//一个槽，哈希表的基础；代表链表结构要素的两个数组-唯一标识
int h[N], e[N],ne[N], idx;
int n;
void insert(int x) {
    int k = ((x % N) + N) % N;
    h[k] = x;
}
int main() {
    cin >> n;
    memset(h, -1, sizeof h);
    while(n--) {
        string s;
        cin >> s;
        if(s == "I") {
            int x;
            cin >> x;
            insert(x);
        }else if(s == "Q") {
            int x;
            cin >> x;
            int res = query(x);
            cout << (res == 0 ? "No" : "Yes")<< endl;
        }
    }



}

