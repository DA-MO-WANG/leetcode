//
// Created by rich heart on 31/07/2022.
//

#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
ListNode *entryNodeOfLoop(ListNode *head) {
    //需要两个指针，一个指针在前面，一个指针在后面
    //证明环的思路1：只有存在环的情况下，前面的指针才有可能走后面的后面
    //思路2：一个指针走的位置以前是否走过，记忆化手段-map存储
    //思路3：快慢指针，两个速度不同的指针，如果没环的话，距离只会越拉越远；有环，存在相遇的可能


    //C++中NULL被当作0处理了
    //空链表和只有一个元素的链表必然不会出环
    if (!head || !head->next) return 0;
    //定义两个指针--这里和java不太一样
    ListNode *first = head, *second = head;

    while (first && second)
    {
        //一开始是快慢指针不同速度，然和实现这个不同速度
        //这里并不是一次性写的，而是分开两部分，快指针的多走一步，单独再处理一次
        first = first->next;
        second = second->next;
        //有一个判空处理
        if (second) second = second->next;
        else return 0;
        //第一次相遇
        if (first == second)
        {
            first = head;
            //这里没搞懂为什么while写在if里面
            //第二次相遇是建立在第一次相遇的基础上的
            //他俩不是并列的，是嵌套在里面的关系
            while (first != second)
            {
                //第一次相遇之后调整的速度
                first = first->next;
                second = second->next;
            }
            return first;
        }
    }
    //NULL当作0处理
    return 0;

    //思路2需要给链表写一个哈希函数
//    unorderd_map<ListNode,int> map;
//    ListNode cur = head;
//    int index = 1;
//    while(cur != NULL) {
//        if(!map[cur]) {
//            map.insert({cur,index++})
//        }else {
//            return cur;
//        }
//    }
//    return null;

}
int main() {

    return 0;
}