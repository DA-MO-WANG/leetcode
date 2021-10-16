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

    public ListNode reverseList(ListNode )
}
