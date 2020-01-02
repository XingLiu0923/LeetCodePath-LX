public class Q300_test2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        int dpn = 0;
        for (int i = 0; i < n; i++) {
            int pos = binarySearch(dp, dpn, nums[i]);
            dp[pos] = nums[i];
            if (pos == dpn) dpn++;
        }
        return dpn;
    }

    private int binarySearch(int[] dp, int dpn, int target) {
        int lo = 0, hi = dpn;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (dp[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
