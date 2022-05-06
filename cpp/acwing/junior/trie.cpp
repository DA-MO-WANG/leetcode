//
// Created by rich heart on 5/6/22.
//
#include <algorithm>
#include <cstring>
#include <iostream>
#include <cstdio>

using namespace std;
const int N = 1e5 + 10;//预估的字符串总长度决定了节点的最大数量，如果没有重用的情况，那就是一个字符一个节点
int n, cnt[N], idx;//cnt[]代表的是以当前节点为单词结尾的次数
//idx代表所用用到的贯穿一切的下标-这个结构中的全局下标
char son[N][26];
void insert(string s) {
    int p = 0;
    for (int i = 0; i < s.size(); ++i) {
        int u = s[i] - 'a';
        if(!son[p][u]) ++idx;
        else p = son[p][u];
    }
    cnt[p]++;//idx和p不完全一样，idx代表全局的最前列
}
int query(string s) {
    int p = 0;//临时节点下标
    for (int i = 0; i < s.size(); ++i) {
        int u = s[i] - 'a';
        if(!son[p][u]) return 0;
        else p = son[p][u];
    }
    if(cnt[p]) return 1;
    else return 0;
}
int main() {
    cin >> n;
    while (n --) {
        char op;
        cin >> op;
        if (op == 'I') {
            string x;
            cin >> x;

        }
    }
}
