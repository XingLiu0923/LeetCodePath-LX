public class Q25_test1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode kBegain = first, kEnd = first, slow = first, fast = head;
        int m = k;
        while (true) {
            while (kEnd != null && m-- > 0) kEnd = kEnd.next;
            if (kEnd == null) break;
            m = k;
            ListNode kMark = kEnd.next;
            while (fast != kMark) {
                ListNode fastNext = fast.next;
                fast.next = slow;
                slow = fast;
                fast = fastNext;
            }
            kEnd = kBegain.next;
            kBegain.next = slow;
            kEnd.next = fast;
            kBegain = kEnd;
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1), node2 = new ListNode(2), node3 = new ListNode(3), node4 = new ListNode(4), node5 = new ListNode(5);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
        new Q25_test1().reverseKGroup(node1, 2);
    }
}