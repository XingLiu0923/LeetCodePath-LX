public class Q147_test1 {
    public ListNode insertionSortList(ListNode head) {
        ListNode first = new ListNode(-1); first.next = head;
        ListNode headPrev = first;
        ListNode prev = first; ListNode fast = head;
        while (head != null) {
            while (fast != head) {
                if (fast.val > head.val) {
                    headPrev.next = head.next;
                    prev.next = head;
                    head.next = fast;
                    break;
                }
                fast = fast.next;
                prev = prev.next;
            }
            if (fast == head) { headPrev = headPrev.next; }
            head = headPrev.next;
            prev = first; fast = prev.next;
        }
        return first.next;
    }
}
