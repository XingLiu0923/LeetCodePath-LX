public class Q143_test1 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode fast = first, slow = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        ListNode half = slow;
        while (fast != null) {
            ListNode fastNext = fast.next;
            fast.next = slow;
            slow =fast;
            fast = fastNext;
        }
        half.next.next = null; half.next = null;
        ListNode prev = first;
        boolean odd = true;
        while (prev != null) {
            if (odd) { prev.next = head; if (head != null) head = head.next; }
            else { prev.next = slow; if (slow != null) slow = slow.next; }
            odd = !odd;
            prev = prev.next;
        }
        head = first.next;
    }
}
