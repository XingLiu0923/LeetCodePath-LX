public class Q21_test2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(-1);
        ListNode prev = first;
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) { prev.next = l2; l2 = l2.next; }
            else { prev.next = l1; l1 = l1.next; }
            prev = prev.next;
        }
        if (l1 == null) prev.next = l2;
        else prev.next = l1;
        return first.next;
    }
}
