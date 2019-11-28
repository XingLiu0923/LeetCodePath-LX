public class Q279_test1 {
    public int numSquares(int n) {
        if (n == Math.pow((int) Math.sqrt(n), 2)) return 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i == Math.pow((int) Math.sqrt(i), 2)) { dp[i] = 1; continue; }
            int minNum = i;
            for (int j = 1; j < Math.sqrt(i); j++) {
                dp[i] = minNum = Math.min(minNum, dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

}
