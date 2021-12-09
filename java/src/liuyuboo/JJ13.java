package liuyuboo;

public class JJ13 {

    //O1复杂度
    //所谓思路的全面性---你写的代码，自己查找成立的前提
    void deleteNode(ListNode head, ListNode deleted) {
        if (deleted.next != null) {
            ListNode dnode = deleted.next;
            deleted.val = dnode.val;//dnode 不为null
            deleted.next = dnode.next;
        }else {
            ListNode cur = head;
            if(cur.next != null) {
                while (cur.next.next != null) {//cur.next != null
                    cur = cur.next;
                }
                cur.next = null;
            }else {
                head = null;
            }


    }

}
