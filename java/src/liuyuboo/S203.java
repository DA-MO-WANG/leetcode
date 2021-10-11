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

    //虚拟头节点解法
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode()；
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            }else {
                pre = pre.next;
            }

        }
        return dummy.next;

    }

    public void delNode(ListNode node) {
        ListNode temp = node;
        node = node.next;
        temp = null;
    }
}
