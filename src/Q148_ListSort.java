public class Q148_ListSort {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        int n = getsize(head);
        return sortList(head, 0, n - 1);
    }

    public static ListNode sortList(ListNode head, int lo, int hi) {
        if (lo >= hi) return head;
        int mid = (lo + hi)/2;
        ListNode headlo = head;
        ListNode headmid = headlo;
        ListNode headhi;
        for (int i = lo; i < mid; i++) {
            headmid = headmid.next;
        }
        headhi = headmid.next;
        headmid.next = null;
        headmid = headhi;
        for (int i = mid + 1; i < hi; i++) {
            headmid = headmid.next;
        }
        headmid.next = null;
        headlo = sortList(headlo, lo, mid);
        headhi = sortList(headhi, mid + 1, hi);
        return mergelist(headlo, headhi, lo, hi);
    }

    public static ListNode mergelist(ListNode head1, ListNode head2, int lo, int hi) {
        ListNode headaux;
        ListNode first;
        if (head2.val < head1.val) headaux = head2;
        else headaux = head1;
        first = headaux;
        for (int k = lo; k < hi; k++) {
            if (headaux.next == null) {
                if (headaux == head1) {
                    headaux.next = head2;
                    break;
                }
                else {
                    headaux.next = head1;
                    break;
                }
            }

            else if (headaux == head1) {
                if (head2.val < headaux.next.val) {
                    head1 = head1.next;
                    headaux.next = head2;
                    headaux = headaux.next;
                }
                else {
                    headaux = headaux.next;
                    head1 = headaux;
                }
            }
            else if (headaux == head2) {
                if (head1.val < headaux.next.val) {
                    head2 = head2.next;
                    headaux.next = head1;
                    headaux = headaux.next;
                }
                else {
                    headaux = headaux.next;
                    head2 = headaux;
                }
            }
        }
        return first;
    }

    public static int getsize(ListNode head) {
        ListNode pos = head;
        if (pos == null) return 0;
        int size = 1;
        while (pos.next != null) {
            pos = pos.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        Q148_ListSort q1 = new Q148_ListSort();
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


