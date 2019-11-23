public class Q110_test1 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight < 0 || rightHeight < 0) return false;
        if (leftHeight - rightHeight > -2 && leftHeight - rightHeight < 2) return true;
        return false;
    }

    private int height(TreeNode x) {
        if (x == null) return 0;
        int xLc = height(x.left);
        if (xLc < 0) return -1;
        int xRc = height(x.right);
        if (xRc < 0) return -1;
        if (xLc - xRc > -2 && xLc - xRc < 2) return Math.max(xLc, xRc) + 1;
        return -1;
    }
}
