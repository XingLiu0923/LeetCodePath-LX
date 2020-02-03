public class Q172_test1 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int j = 0; j < n2 + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < n1 + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                int add = dp[i][j - 1] + 1;
                int remove = dp[i - 1][j] + 1;
                int change = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : (dp[i - 1][j - 1] + 1);
                dp[i][j] = Math.min(add, Math.min(remove, change));
            }
        }
        return dp[n1][n2];
    }
}
