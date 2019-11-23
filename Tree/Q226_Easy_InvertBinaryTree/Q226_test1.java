public class Q226_test1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode rootLeft = invertTree(root.right);
        TreeNode rootRight = invertTree(root.left);
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }
}
