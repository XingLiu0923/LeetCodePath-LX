public class Q21_test1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first1 = new ListNode(-1); first1.next = l1;
        ListNode fast1 = l1, slow1 = first1;
        ListNode fast2 = null, slow2 = l2;
        while (fast1 != null && slow2 != null) {
            fast2 = slow2.next;
            if (slow2.val < fast1.val) {
                slow1.next = slow2; slow2.next = fast1; slow2 = fast2;
            }
            slow1 = slow1.next; fast1 = slow1.next;
        }
        if (fast1 == null) slow1.next = slow2;
        return first1.next;
    }
}
