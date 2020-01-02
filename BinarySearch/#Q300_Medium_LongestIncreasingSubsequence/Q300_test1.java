public class Q300_test1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }
            dp[i] = dp[i] > 1 ? dp[i] : 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }
}
