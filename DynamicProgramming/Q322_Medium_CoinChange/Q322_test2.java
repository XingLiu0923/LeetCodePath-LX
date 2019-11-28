public class Q322_test2 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) continue;
            dp[coins[i]] = 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            if (dp[i] == 0) continue;
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] > amount || i + coins[j] < 0) continue;
                dp[i + coins[j]] = (dp[i + coins[j]] == 0) ? dp[i] + 1 : Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        if (dp[amount] == 0) return -1;
        return dp[amount];
    }
}
