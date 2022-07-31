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
    ListNode fast = head, slow = head;
    int count = 0;
    while(fast != NULL && slow != NULL) {
        if(count == 0) {
            fast = fast.next->next;
            slow = slow.next;
        }
        if(count = 0 && fast == slow) {
            slow = head;
            count++;

        }
        if(count > 0) {
            fast = fast.next;
            slow = slow.next;
        }
        if(count >= 0 && fast == slow) {
            return fast;
        }
    }
    return NULL;

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