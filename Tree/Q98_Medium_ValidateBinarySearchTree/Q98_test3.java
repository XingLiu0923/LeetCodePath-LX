public class Q98_test3 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode x, int lo_limit, int hi_limit) {
        if (x == null) return true;
        if (x.val <= lo_limit || x.val >= hi_limit) return false;
        return isValidBST(x.left, lo_limit, x.val) && isValidBST(x.right, x.val, hi_limit);
    }
}
