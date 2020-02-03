public class Q114_test1 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode x = root.left;
        if (x == null) return;
        while (x.right != null) x = x.right;
        x.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
