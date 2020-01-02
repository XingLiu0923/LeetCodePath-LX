public class Q82_test1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode slow = first, fast = head;
        boolean mark = false;
        while (fast != null) {
            while (fast != null && fast.next != null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
            if (fast != null) fast = fast.next;
        }
        return first.next;
    }
}
