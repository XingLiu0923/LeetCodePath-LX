public class Q148_ListSort_Improve {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;     //递归出口
        ListNode lo = head;
        ListNode middle = getMiddle(head);
        ListNode hi = middle.next;
        middle.next = null;     //链表断开为左右两边
        lo = sortList(lo);
        hi = sortList(hi);
        return mergeList(lo, hi);
    }

    public ListNode mergeList(ListNode lo, ListNode hi) {
        ListNode headaux = new ListNode(-1);
        ListNode first = headaux;
        while (lo != null && hi != null) {
            if (hi.val < lo.val) {
                headaux.next = hi;
                hi = hi.next;
            }
            else {
                headaux.next = lo;
                lo = lo.next;
            }
            headaux = headaux.next;
        }
        if (lo == null) {
            headaux.next = hi;
        }
        else {
            headaux.next = lo;
        }
        return first.next;
    }

    public static ListNode getMiddle(ListNode head) {
        ListNode lo = head;
        ListNode hi = head;
        while (hi.next != null && hi.next.next != null) {
            lo = lo.next;
            hi = hi.next.next;
        }
        return lo;
    }

    public static void main(String[] args) {
        Q148_ListSort_Improve q1 = new Q148_ListSort_Improve();
        ListNode head1 = q1.new ListNode(5);
        ListNode head2 = q1.new ListNode(3);
        ListNode head3 = q1.new ListNode(4);
        ListNode head4 = q1.new ListNode(1);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        System.out.print(head1.val + " " + head2.val + " " + head3.val + " " + head4.val + "\n");
        ListNode head = q1.sortList(head1);
        System.out.println(head.val);
        head = head.next;
        System.out.println(head.val);
        head = head.next;
        System.out.println(head.val);
        head = head.next;
        System.out.println(head.val);
    }
}
