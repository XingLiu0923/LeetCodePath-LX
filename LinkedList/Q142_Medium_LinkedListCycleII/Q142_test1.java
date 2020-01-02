public class Q142_test1 {
    public ListNode detectCycle(ListNode head) {
        ListNode first = new ListNode(-1); first.next = head;
        ListNode fast = first, slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        fast = first;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
