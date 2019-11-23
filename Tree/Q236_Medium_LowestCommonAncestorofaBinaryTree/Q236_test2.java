public class Q236_test2 {
    Integer count = 0;
    TreeNode target = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || target != null) return target;
        int InitialCount = count;
        if (root.val == p.val || root.val == q.val) count++;
        if (root.left != null) lowestCommonAncestor(root.left, p, q);
        if (count - InitialCount == 2 && target == null) target = root;
        if (root.right != null) lowestCommonAncestor(root.right, p, q);
        if (count - InitialCount == 2 && target == null) target = root;
        return target;
    }
}
