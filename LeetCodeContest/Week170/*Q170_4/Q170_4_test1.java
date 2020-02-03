public class Q170_4_test1 {
    public int minInsertions(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                if (chars[i] == chars[i + k]) dp[i][i + k] = dp[i + 1][i + k - 1] + 2;
                else dp[i][i + k] = Math.max(dp[i + 1][i + k], dp[i][i + k - 1]);
            }
        }
        return n - dp[0][n - 1];
    }
}
