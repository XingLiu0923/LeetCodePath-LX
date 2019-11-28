public class Q312_test1 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] newN = new int[n + 2];
        newN[0] = newN[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            newN[i] = nums[i - 1];
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = newN[i - 1] * newN[i] * newN[i + 1];
        }
        for (int gap = 1; gap <= n - 1; gap++) {
            for (int i = 1; i + gap <= n; i++) {
                int tmpMax = Integer.MIN_VALUE;
                for (int k = i; k <= i + gap; k++) {
                    int tmp = newN[i - 1] * newN[k] * newN[i + gap + 1] + dp[i][k - 1] + dp[k + 1][i + gap];
                    if (tmp > tmpMax) tmpMax = tmp;
                }
                dp[i][i + gap] = tmpMax;
            }
        }
        return dp[1][n];
    }
}
