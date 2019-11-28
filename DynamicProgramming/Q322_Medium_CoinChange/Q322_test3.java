public class Q322_test3 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) dp[coins[i]] = 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            if (dp[i] == 1) continue;
            for (Integer coin : coins) {
                if (i - coin > 0 && dp[i - coin] != 0) dp[i] = dp[i] == 0 ? dp[i - coin] + 1 : Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] == 0) return -1;
        return dp[amount];
    }
}