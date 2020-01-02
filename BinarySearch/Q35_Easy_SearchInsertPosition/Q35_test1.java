public class Q35_test1 {
    public int searchInsert(int[] nums, int target) {       // 找到大于等于target的最小位置；
        int n = nums.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
