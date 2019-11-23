public class Q108_test1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int lo = 0, hi = nums.length;
        return sortedArrayToBST(nums, lo, hi);
    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo >= hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode x = new TreeNode(nums[mid]);
        x.left = sortedArrayToBST(nums, lo, mid);
        x.right = sortedArrayToBST(nums, mid + 1, hi);
        return x;
    }
}
