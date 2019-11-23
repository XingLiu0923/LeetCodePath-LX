public class Q109_test1 {
    public TreeNode sortedListToBST(ListNode head) {
        int lo = 0, hi = 0;
        ListNode x = head;
        while (x != null) {
            x = x.next; hi++;
        }
        return sortedListToBST(head, lo, hi);
    }

    private TreeNode sortedListToBST(ListNode head, int lo, int hi) {
        if (lo >= hi || head == null) return null;
        ListNode x = head;
        int mid = lo + (hi - lo) / 2;
        for (int i = lo; i < mid; i++) {
            x = x.next;
        }
        TreeNode root = new TreeNode(x.val);
        root.left = sortedListToBST(head, lo, mid);
        root.right = sortedListToBST(x.next, mid + 1, hi);
        return root;
    }
}
