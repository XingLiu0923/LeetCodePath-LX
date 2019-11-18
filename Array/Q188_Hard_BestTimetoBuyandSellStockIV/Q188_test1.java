public class Q188_test1 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        if (k == 0) return 0;
        if (k >= n / 2) return maxProfit(prices);

        int[][] dp = new int[k + 1][2];
        int[][] dptmp = new int[k + 1][2];

        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;   dp[1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            copy(dp, dptmp);
            dp[0][0] = 0; dp[0][1] = Integer.MIN_VALUE;
            for (int j = 1; j < k + 1; j++) {
                dp[j][0] = Math.max(dptmp[j][0], dptmp[j][1] + prices[i]);
                dp[j][1] = (dptmp[j - 1][0] < 0 && dptmp[j - 1][0] - prices[i] > 0) ? Integer.MIN_VALUE : Math.max(dptmp[j][1], dptmp[j - 1][0] - prices[i]);
            }
        }
        return getMax(dp, k);
    }

    private void copy(int[][] oldArray, int[][] newArray) {
        int rows = oldArray.length;
        int cols = oldArray[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newArray[i][j] = oldArray[i][j];
            }
        }
    }

    private int getMax(int[][] dp, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k + 1; i++) {
            if (max < dp[i][0]) max = dp[i][0];
        }
        return max;
    }

    private int maxProfit(int[] prices) {
        int n = prices.length;
        int selStatus = 0;
        int holdStatus = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            int tmpSel = selStatus; int tmpHold = holdStatus;
            selStatus = Math.max(tmpSel, tmpHold + prices[i]);
            holdStatus = Math.max(tmpHold, tmpSel - prices[i]);
        }
        return selStatus;
    }
}