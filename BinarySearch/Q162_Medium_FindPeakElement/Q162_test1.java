public class Q162_test1 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid < n - 1 && nums[mid] < nums[mid + 1]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
