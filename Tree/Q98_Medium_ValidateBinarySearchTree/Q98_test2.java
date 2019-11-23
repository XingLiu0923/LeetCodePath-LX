public class Q98_test2 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode x, Integer low_bond, Integer hi_bond) {
        if (x == null) return true;
        if ((low_bond != null && x.val <= low_bond) || (hi_bond != null && x.val >= hi_bond)) return false;
        if (!isValidBST(x.left, low_bond, x.val) || !isValidBST(x.right, x.val, hi_bond)) return false;
        if (x.left != null && x.val <= x.left.val) return false;
        if (x.right != null && x.val >= x.right.val) return false;
        return true;
    }
}
