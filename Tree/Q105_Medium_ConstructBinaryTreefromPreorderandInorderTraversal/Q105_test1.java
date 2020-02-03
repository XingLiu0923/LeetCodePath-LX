public class Q105_test1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, 0, n, inorder, 0, n);
    }

    private TreeNode buildTree(int[] preorder, int lo_pre, int hi_pre, int[] inorder, int lo_in, int hi_in) {
        if (lo_pre >= hi_pre) return null;
        TreeNode x = new TreeNode(preorder[lo_pre]);
        int xP = lo_in;
        while (inorder[xP] != preorder[lo_pre]) xP++;
        int leftL = xP - lo_in;
        x.left = buildTree(preorder, lo_pre + 1, lo_pre + 1 + leftL, inorder, lo_in, xP);
        x.right = buildTree(preorder, lo_pre + 1 + leftL, hi_pre, inorder, xP + 1, hi_in);
        return x;
    }
}