public class Q174_test1 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (i == m - 1 && j == n - 1) dp[i][j] = Math.max(-dungeon[i][j], 0);
                else if (i == m - 1) dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 0);
                else if (j == n - 1) dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 0);
                else dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0];
    }
}
