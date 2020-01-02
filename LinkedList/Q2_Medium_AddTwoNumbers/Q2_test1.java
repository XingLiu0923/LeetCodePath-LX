public class Q2_test1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first1 = new ListNode(-1), first2 = new ListNode(-1);
        first1.next = l1; first2.next = l2;
        ListNode fast1 = l1, slow1 = first1;
        ListNode fast2 = l2, slow2 = first2;
        ListNode resultFirst = new ListNode(-1);
        ListNode resultFast = null, resultSlow = resultFirst;
        while (fast1 != null && fast2 != null) {
            resultFast = new ListNode(fast1.val + fast2.val);
            resultSlow.next = resultFast;
            if (resultSlow.val >= 10) { resultSlow.val -= 10; resultFast.val += 1; }
            resultSlow = resultSlow.next;
            fast1 = fast1.next; slow1 = slow1.next;
            fast2 = fast2.next; slow2 = slow2.next;
        }
        while (fast1 != null) {
            resultFast = new ListNode(fast1.val);
            resultSlow.next = resultFast;
            if (resultSlow.val >= 10) { resultSlow.val -= 10; resultFast.val +=1; }
            resultSlow = resultSlow.next;
            fast1 = fast1.next; slow1 = slow1.next;
        }
        while (fast2 != null) {
            resultFast = new ListNode(fast2.val);
            resultSlow.next = resultFast;
            if (resultSlow.val >= 10) { resultSlow.val -= 10; resultFast.val +=1; }
            resultSlow = resultSlow.next;
            fast2 = fast2.next; slow2 = slow2.next;
        }
        if (resultSlow.val >= 10) { resultSlow.val -= 10; resultFast = new ListNode(1); resultSlow.next = resultFast; }
        return resultFirst.next;
    }
}

