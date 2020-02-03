public class Q173_4_test1 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][][] dp = new int[n][n][d];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = max(jobDifficulty, i, j);
            }
        }
        for (int k = 1; k < d; k++) {
            for (int i = 0; i + k < n; i++) {
                for (int j = i + k; j < n; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int t = i + k - 1; t < j; t++) {
                        min = Math.min(min, dp[i][t][k - 1] + dp[t + 1][j][0]);
                    }
                    dp[i][j][k] = min;
                }
            }
        }
        return dp[0][n - 1][d - 1];
    }

    private int max(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) max = Math.max(nums[k], max);
        return max;
    }
}
