public class Q5274_test1 {
    public int numWays(int steps, int arrLen) {
        long[] dp = new long[arrLen];
        long[] lastdp = new long[arrLen];
        dp[0] = 1;
        for (int i = 1; i < arrLen; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i < steps + 1; i++) {
            for (int j = 0; j < arrLen; j++) {
                lastdp[j] = dp[j];
            }
            for (int k = 0; k < arrLen; k++) {
                if (k == 0) dp[k] = (lastdp[k] + lastdp[k + 1]) % 1000000007;
                else if (k == arrLen - 1) dp[k] = (lastdp[k - 1] + lastdp[k])% 1000000007;
                else dp[k] = (lastdp[k - 1] + lastdp[k] + lastdp[k + 1]) % 1000000007;
            }
        }
        return (int) (dp[0] % 1000000007);
    }

    public static void main(String[] args) {
        new Q5274_test1().numWays(3, 2);
    }
}
