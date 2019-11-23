public class Q109_test3 {
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode x = head;
        while (x != null) {
            n++;
            x = x.next;
        }
        return sortedListToBST(0, n);
    }

    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo >= hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode lc = sortedListToBST(lo, mid);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = lc;
        root.right = sortedListToBST(mid + 1, hi);
        return root;
    }
}
