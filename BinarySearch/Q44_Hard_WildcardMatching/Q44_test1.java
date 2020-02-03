public class Q44_test1 {
    public boolean isMatch(String s, String p) {
        int ns = s.length(), np = p.length();
        boolean[][] dp = new boolean[np + 1][ns + 1];
        for (int j = 0; j < ns + 1; j++) {
            dp[0][j] = j == 0;
        }
        for (int i = 1; i < np + 1; i++) {
            int cp = p.charAt(i - 1);
            for (int j = 0; j < ns + 1; j++) {
                if (cp >= 'a' && cp <= 'z') dp[i][j] = (j > 0) && (cp == s.charAt(j - 1)) && dp[i - 1][j - 1];
                else if (cp == '?') dp[i][j] = (j > 0) && dp[i - 1][j - 1];
                else {
                    dp[i][j] = dp[i - 1][j] || (j > 0 && dp[i][j - 1]);
                }
            }
        }
        return dp[np][ns];
    }

    public static void main(String[] args) {
        new Q44_test1().isMatch("", "*");
    }
}
