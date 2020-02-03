public class Q213_test1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[][] dp = new int[2][2];
        dp[0][0] = nums[0]; dp[0][1] = -1; dp[1][0] = -1; dp[1][1] = 0;
        for (int i = 1; i < n; i++) {
            int[][] t = new int[2][2];
            t[0][0] = dp[0][0]; t[0][1] = dp[0][1]; t[1][0] = dp[1][0]; t[1][1] = dp[1][1];
            dp[0][0] = Math.max(0, t[1][0]) + nums[i];
            dp[1][0] = Math.max(t[1][0], t[0][0]);
            dp[0][1] = Math.max(0, t[1][1]) + nums[i];
            dp[1][1] = Math.max(t[0][1], t[1][1]);
        }
        return Math.max(dp[1][0], Math.max(dp[0][1], dp[1][1]));
    }
}
