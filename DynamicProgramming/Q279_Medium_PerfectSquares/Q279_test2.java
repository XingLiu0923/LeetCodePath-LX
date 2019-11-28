public class Q279_test2 {
    public int numSquares(int n) {
        if (n == Math.pow((int) Math.sqrt(n), 2)) return 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i == Math.pow((int) Math.sqrt(i), 2)) { dp[i] = 1; continue; }
            dp[i] = i;
            for (int j = 1; j < Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
