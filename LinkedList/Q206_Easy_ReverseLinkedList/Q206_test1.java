public class Q206_test1 {
    public ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode second = null;
        while (head != null) {
            first = head;
            head = head.next;
            first.next = second;
            second = first;
        }
        return first;
    }
}
