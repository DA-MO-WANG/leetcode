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
int hashx(int x) {
    return ((x % N) + N) % N;
}
void insert(int x) {
    int k = hashx(x);

    //无论这个槽上是不是空，头插法来说，代码是一样的
    e[idx] = x;
    //头插法还是尾插法的选择-这里是头插法
    ne[idx] = h[k];
    h[k] = idx;
    idx++;

}
int query(int x) {
    int k = hashx(x);
    if(h[k] == -1) {
        return 0;
    }else {
        for (int i = h[k]; i != -1 ; i = ne[i]) {
            if(e[i] == x) {
                return 1;
                break;
            }
        }
        return 0;
    }

}
int main() {
    cin >> n;
    //对槽初始化，赋予初值-1，代表空槽状态
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

