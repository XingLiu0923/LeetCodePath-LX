public class Q234_test1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode fast = first, slow = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 调转slow后面的listnode。
        ListNode half = slow;
        fast = slow.next;
        while (fast != null) {
            ListNode mark = fast.next;
            fast.next = slow;
            slow = fast;
            fast = mark;
        }
        half.next.next = fast;
        half.next = slow;
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
