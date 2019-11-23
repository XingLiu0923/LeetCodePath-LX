public class Q124_test1 {
    int partMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int maxIncludeRoot = maxIncludeThis(root);
        int maxExcludeRoot = maxExcludeThis(root);
        return Math.max(partMax, Math.max(maxExcludeRoot, maxIncludeRoot));
    }

    private int maxIncludeThis(TreeNode x) {
        if (x == null) return Integer.MIN_VALUE;
        if (x.left == null && x.right == null) return x.val;
        int MaxLeftInclude = maxIncludeThis(x.left), MaxRightInclude = maxIncludeThis(x.right);
        if (x.left == null) return Math.max(MaxRightInclude + x.val, x.val);
        if (x.right == null) return Math.max(MaxLeftInclude + x.val, x.val);
        if (MaxLeftInclude + MaxRightInclude + x.val > partMax) partMax = MaxLeftInclude + MaxRightInclude + x.val;
        return Math.max(x.val, Math.max(MaxLeftInclude + x.val, MaxRightInclude + x.val));
    }

    private int maxExcludeThis(TreeNode x) {
        if (x == null) return Integer.MIN_VALUE;
        if (x.left == null && x.right == null) return Integer.MIN_VALUE;
        int MaxLeftInclude = maxIncludeThis(x.left), MaxRightInclude = maxIncludeThis(x.right);
        int MaxLeftExclude = maxExcludeThis(x.left), MaxRightExclude = maxExcludeThis(x.right);
        if (x.left == null) return Math.max(MaxRightInclude, MaxRightExclude);
        if (x.right == null) return Math.max(MaxLeftInclude, MaxLeftExclude);
        return Math.max(MaxLeftExclude, Math.max(MaxLeftInclude, Math.max(MaxRightExclude, MaxRightInclude)));
    }

}
