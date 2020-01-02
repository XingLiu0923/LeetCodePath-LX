public class Q152_test2 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1]; dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (dp[i - 1] * nums[i - 1] > 0) dp[i] = dp[i - 1] * nums[i - 1];
            else dp[i] = nums[i - 1];
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }
}
