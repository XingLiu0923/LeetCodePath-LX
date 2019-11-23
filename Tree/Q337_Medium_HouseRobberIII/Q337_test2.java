public class Q337_test2 {
    public int rob(TreeNode root) {
        int[] robResult = robMax(root);
        return Math.max(robResult[0], robResult[1]);
    }

    private int[] robMax(TreeNode x) {
        int[] Max = new int[2];     // Max[0]不包括当前，Max[1]包括当前；
        if (x == null) return Max;
        int[] MaxLeft = robMax(x.left);
        int[] MaxRight = robMax(x.right);
        Max[0] = Math.max(MaxLeft[0], MaxLeft[1]) + Math.max(MaxRight[0], MaxRight[1]);
        Max[1] = MaxLeft[0] + MaxRight[0] + x.val;
        return Max;
    }
}
