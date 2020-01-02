public class Q86_test1 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode first = new ListNode(-1); first.next = head;
        ListNode newFirst = new ListNode(-1);
        ListNode prev = newFirst;
        ListNode slow = first, fast = head;
        while (fast != null) {
            if (fast.val >= x) {
                prev.next = fast;
                slow.next = fast.next;
                fast.next = null;
                fast = slow.next;
                prev = prev.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = newFirst.next;
        return first.next;
    }
}
