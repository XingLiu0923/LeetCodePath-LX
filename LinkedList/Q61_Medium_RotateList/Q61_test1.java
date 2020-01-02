public class Q61_test1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int n = 0;
        ListNode first = new ListNode(-1); first.next = head;
        ListNode fast = first;
        while (fast.next != null) {
            fast = fast.next;
            n++;
        }
        fast.next = head;
        k = n - k % n;
        while (k-- > 0) {
            fast = fast.next;
        }
        head = fast.next;
        fast.next = null;
        return head;
    }
}
