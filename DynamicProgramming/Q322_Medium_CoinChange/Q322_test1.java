public class Q322_test1 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) dp[coins[i]] = 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            if (dp[i] == 1) continue;
            Integer tmpMin = null;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) continue;
                if (dp[i - coins[j]] != 0 && (tmpMin == null || tmpMin > dp[i - coins[j]])) tmpMin = dp[i - coins[j]];
            }
            if (tmpMin != null) dp[i] = tmpMin + 1;
        }
        if (dp[amount] == 0) return -1;
        return dp[amount];
    }
}
