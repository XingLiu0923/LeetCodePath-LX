public class Q96_test1 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        return dp[n];
    }
}
