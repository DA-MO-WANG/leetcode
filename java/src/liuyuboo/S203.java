package liuyuboo;

public class S203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            //delNode(head);
            ListNode delNode = head;
            head = head.next;
            delNode = null;
        }
        if (head == null) {
            return head;
        }

        while (head.next != null && head.next.val == val) {
            ListNode delNode = head.next;
            head.next = head.next.next;
            delNode = null;
        }
        return head;
    }

    public void delNode(ListNode node) {
        ListNode temp = node;
        node = node.next;
        temp = null;
    }
}
