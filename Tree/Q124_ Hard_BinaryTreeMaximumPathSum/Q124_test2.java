
public class Q124_test2 {

    private int partMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return Math.max(oneRoadMax(root), partMax);
    }

    private int oneRoadMax(TreeNode x) {
        if (x == null) return 0;
        int lm = oneRoadMax(x.left);
        int mr = oneRoadMax(x.right);
        int update = Math.max(Math.max(lm, mr) + x.val, x.val);
        partMax = Math.max(partMax, Math.max(update, lm + mr + x.val));
        return update;
    }
}
