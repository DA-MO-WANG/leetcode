package liuyuboo;

public class S206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;

            cur = next;
            next = next.next;

        }
        return pre;

    }
    ListNode cur = null;
    //函数签名：反转后，返回反转链表的尾部节点
    public ListNode reverseList1(ListNode head) {
        if (head.next == null) {
            cur = head;
            return head;
        }
        ListNode root = reverseList1(head.next);
        root.next = head;
        return head;
    }
    public ListNode reverseList2(ListNode head) {
         reverseList1(head);
         return cur;
    }
}
