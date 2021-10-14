package liuyuboo;

public class LinkedlistProblem {
    //s1-迭代版
    int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    //s1-递归版
    int count2(ListNode head) {
        if (head == null) return 0;
        countdg(head);
        return size;
    }
    int size = 0;
    void countdg(ListNode head) {
        size++;
        if (head == null) {
            return;
        }
        countdg(head.next);
    }
}
