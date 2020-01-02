public class Q160_test1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fastA = headA, fastB = headB;
        while (fastA != null && fastB != null) { fastA = fastA.next; fastB = fastB.next; }
        if (fastA == null) {
            ListNode slowB = headB;
            while (fastB != null) {
                slowB = slowB.next;
                fastB = fastB.next;
            }
            ListNode slowA = headA;
            while (slowA != null) {
                if (slowA == slowB) return slowA;
                slowA = slowA.next;
                slowB = slowB.next;
            }
        } else {
            ListNode slowA = headA;
            while (fastA != null) {
                slowA = slowA.next;
                fastA = fastA.next;
            }
            ListNode slowB = headB;
            while (slowB != null) {
                if (slowA == slowB) return slowB;
                slowA = slowA.next;
                slowB = slowB.next;
            }
        }
        return null;
    }
}
