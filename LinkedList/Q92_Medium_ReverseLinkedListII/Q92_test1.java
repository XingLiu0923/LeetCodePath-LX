public class Q92_test1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode mLast = first;
        n = n - m;
        while (--m > 0) mLast = mLast.next;
        ListNode mBegin = mLast.next;
        ListNode moveSlow = mBegin;
        ListNode moveFast = moveSlow.next;
        while (n-- > 0) {
            ListNode nextMark = moveFast.next;
            moveFast.next = moveSlow;
            moveSlow = moveFast;
            moveFast = nextMark;
        }
        mLast.next = moveSlow;
        mBegin.next = moveFast;
        return first.next;
    }
}
