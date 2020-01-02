public class Q24_test1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode lastPair = null;
        head = head.next;
        while (first != null && first.next != null) {
            ListNode second = first.next;
            ListNode nextPair = first.next.next;
            second.next = first;
            first.next = nextPair;
            if (lastPair != null) lastPair.next = second;
            lastPair = first;
            first = nextPair;
        }
        return head;
    }
}
