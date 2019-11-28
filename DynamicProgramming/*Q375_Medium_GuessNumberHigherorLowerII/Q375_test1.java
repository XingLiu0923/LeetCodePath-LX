
public class Q375_test1 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        int tmp = 0;
        for (int gap = 1; gap <= n - 1; gap++) {
            for (int i = 1; i + gap <= n; i++) {        // 起始点；
                dp[i][i + gap] = Integer.MAX_VALUE;
                for (int k = i; k <= i + gap; k++) {        // 选取的点；
                    if (k == i) tmp = k + dp[i + 1][i + gap];
                    else if (k == i + gap) tmp = k + dp[i][k - 1];
                    else tmp = k + Math.max(dp[i][k - 1], dp[k + 1][i + gap]);
                    dp[i][i + gap] = tmp < dp[i][i + gap] ? tmp : dp[i][i + gap];
                }
            }
        }
        return dp[1][n];
    }
}
