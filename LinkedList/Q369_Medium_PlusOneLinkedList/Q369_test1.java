public class Q369_test1 {
    public ListNode plusOne(ListNode head) {
        ListNode first = new ListNode(-1); first.next = head;
        ListNode slow = first, fast = head;
        while (fast != null) {
            while (fast != null && fast.val == 9) fast = fast.next;
            if (fast == null) break;
            slow = fast;
            fast = fast.next;
        }
        if (slow.val == -1) {
            slow.next = new ListNode(0);
            slow.next.next = head;
            slow = slow.next;
            head = slow;
        }
        slow.val++; slow = slow.next;
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }
        return head;
    }
}
