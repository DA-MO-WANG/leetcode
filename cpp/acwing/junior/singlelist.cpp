//
// Created by rich heart on 4/2/22.
//
#include <iostream>
#include <cstdio>
#include <cmath>
#include <algorithm>
#include <cstring>

using namespace std;
//创建了一个结构体
struct ListNode{
    int val;
    ListNode *next;
    ListNode(int x) : val(x),next(NULL){}
};
ListNode *head;
int m;
int main() {

    cin >> m;
    while(m--) {
        string s = "";
        cin >> s;
        //读取操作指令
        if(s[0] == 'H') {
            ListNode* cur = new ListNode(s[2]);
            cur  -> next = head;
        }else if(s[0] = 'D') {
            
        }
        //
    }

}
