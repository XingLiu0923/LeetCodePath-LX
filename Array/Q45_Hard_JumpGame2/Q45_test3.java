public class Q45_test3 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = -1;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (i + nums[i] >= n - 1) return dp[i] + 1;
            for (int j = i + nums[i]; j > i && dp[j] == -1; j--) {
                dp[j] = dp[i] + 1;
            }
        }
        return dp[n - 1];
    }
}
