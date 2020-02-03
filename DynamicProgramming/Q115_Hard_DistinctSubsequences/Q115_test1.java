public class Q115_test1 {
    public int numDistinct(String s, String t) {
        int ns = s.length(), nt = t.length();
        int[][] dp = new int[ns + 1][nt + 1];
        for (int i = 0; i < ns + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < ns + 1; i++) {
            char ci = s.charAt(i - 1);
            for (int j = 1; j < nt + 1; j++) {
                char cj = t.charAt(j - 1);
                dp[i][j] = dp[i - 1][j];
                if (ci == cj) dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[ns][nt];
    }
}
