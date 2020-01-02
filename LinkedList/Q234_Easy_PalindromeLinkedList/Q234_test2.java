public class Q234_test2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode fast = first, slow = first;
        ListNode slowAhead = slow.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode slowMark = slowAhead.next;
            slowAhead.next = slow;
            slow = slowAhead;
            slowAhead = slowMark;
        }
        first.next.next = slowAhead;
        first.next = slow;
        if (fast == null) slow = slow.next;
        while (slowAhead != null) {
            if (slow.val != slowAhead.val) return false;
            slow =slow.next; slowAhead = slowAhead.next;
        }
        return true;
    }
}
