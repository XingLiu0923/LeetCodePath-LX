public class Q154_test1 {
    /* 本质上是找到小于等于mark的最小值 */
    public int findMin(int[] nums) {
        int n = nums.length;
        int index =  findMinIn(nums, 0, n);
        return nums[index];
    }

    private int findMinIn(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            if (lo > -1 && lo < nums.length) return lo;
            else return 0;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > nums[0]) return findMinIn(nums, mid + 1, hi);
        else if (nums[mid] < nums[0]) return findMinIn(nums, lo, mid);
        else {
            int leftMinIndex = findMinIn(nums, lo, mid);
            int rightMinIndex = findMinIn(nums, mid + 1, hi);
            int minIndex = nums[leftMinIndex] < nums[rightMinIndex] ? leftMinIndex : rightMinIndex;
            return minIndex;
        }
    }
}
