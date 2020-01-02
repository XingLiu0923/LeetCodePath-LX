public class Q19_test1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode slow = first;
        ListNode mark = head;
        while (n-- > 0) mark = mark.next;
        while (mark != null) {
            mark = mark.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return first.next;
    }
}
