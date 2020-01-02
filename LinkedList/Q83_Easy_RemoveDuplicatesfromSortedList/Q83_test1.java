public class Q83_test1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode slow = first;
        ListNode fast = head;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
            fast = fast.next;
        }
        return first.next;
    }
}
