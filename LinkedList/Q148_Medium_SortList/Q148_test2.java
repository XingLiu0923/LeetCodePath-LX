public class Q148_test2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        return mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode lo, ListNode hi) {
        if (lo.next == hi) return lo;
        ListNode mid = getMidNode(lo, hi);
        ListNode midNext = mid.next;
        mid.next = null;
        lo = mergeSort(lo, mid.next);
        midNext = mergeSort(midNext, hi);
        return merge(lo, midNext, hi);
    }

    private ListNode getMidNode(ListNode lo, ListNode hi) {
        ListNode first = new ListNode(-1);
        first.next = lo;
        ListNode slow = first, fast = first;
        while (fast != hi && fast.next != hi) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode lo, ListNode mid, ListNode hi) {
        ListNode first = new ListNode(-1);
        ListNode prev = first;
        while (prev != null) {
            if (lo == null) { prev.next = mid; break; }
            else if (mid == null) { prev.next = lo; break; }
            else if (mid.val < lo.val) { prev.next = mid; mid = mid.next; }
            else { prev.next = lo; lo = lo.next; }
            prev = prev.next;
        }
        return first.next;
    }
}
