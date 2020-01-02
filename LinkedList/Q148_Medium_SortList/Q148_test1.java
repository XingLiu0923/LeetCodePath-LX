public class Q148_test1 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        sortList(head, null);
        return head;
    }

    private void sortList(ListNode loNode, ListNode hiNode) {
        if (loNode == hiNode) return;
        ListNode partionNode = partition(loNode, hiNode);
        sortList(loNode, partionNode);
        sortList(partionNode.next, hiNode);
    }

    private ListNode partition(ListNode loNode, ListNode hiNode) {
        ListNode j = loNode.next, i = loNode;
        while (j != hiNode) {
            if (j.val < loNode.val)  { i = i.next; swap(i, j); }
            j = j.next;
        }
        swap(loNode, i);
        return i;
    }

    private void swap(ListNode i, ListNode j) {
        int t = i.val;
        i.val = j.val;
        j.val = t;
    }
}
