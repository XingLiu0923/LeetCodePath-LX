public class Q298_test1 {

    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        longestConsecutiveCount(root);
        return max;
    }

    private int longestConsecutiveCount(TreeNode x) {
        if (x == null) return 0;
        int leftNum = longestConsecutiveCount(x.left);
        int rightNum = longestConsecutiveCount(x.right);
        int xNumberL = 1;
        int xNumberR = 1;
        if (x.left == null || x.left.val == x.val + 1) xNumberL = leftNum + 1;
        if (x.right == null || x.right.val == x.val + 1) xNumberR = rightNum + 1;
        int maxXNumber = Math.max(xNumberR, xNumberL);
        if (maxXNumber > max) max = maxXNumber;
        return maxXNumber;
    }
}
