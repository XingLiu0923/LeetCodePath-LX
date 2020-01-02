public class Q1000_test1 {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = stones[i - 1];
        }
        for (int gapTimes = 1; gapTimes <= (n - 1)/(K - 1); gapTimes++) {
            for (int i = 1; i + gapTimes * (K - 1) <= n; i++) {
                int min = Integer.MAX_VALUE;
                int end = i + gapTimes * (K - 1);
                for (int j = i; j <= i + K - 1; j++) {
                    if (gapTimes == 1) dp[i][end] = sum(stones, i - 1, j - 2) + dp[j][j + (gapTimes-1)*(K-1)] + sum(stones, j + (gapTimes-1)*(K-1), end - 1);
                    else dp[i][end] = sum(stones, i - 1, j - 2) + 2 * dp[j][j + (gapTimes-1)*(K-1)] + sum(stones, j + (gapTimes-1)*(K-1), end - 1);
                    min = dp[i][end] < min ? dp[i][end] : min;
                }
                dp[i][end] = min;
            }
        }
        return dp[1][n];
    }

    private int sum(int[] stones, int i, int j) {
        int sum = 0;
        while (i <= j) {
            sum = sum + stones[i++];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] stones = {3, 5, 1, 2};
        new Q1000_test1().mergeStones(stones, 2);
    }
}
