public class Q203_test1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode slow = first, fast = head;
        while (fast != null) {
            while (fast != null && fast.val == val) fast = fast.next;
            slow.next = fast;
            slow = slow.next;
            if (fast != null) fast = fast.next;
        }
        return first.next;
    }
}
