public class Q123_test1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[3][2];     // 已交易次数 x 状态；
        int[][] dptmp = new int[3][2];
        dp[0][0] = 0;  dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = Integer.MIN_VALUE;   dp[1][1] = -prices[0];
        dp[2][0] = Integer.MIN_VALUE;   dp[2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            copy(dp, dptmp);
            dp[0][0] = 0;
            dp[0][1] = Integer.MIN_VALUE;
            for (int k = 1; k < 3; k++) {
                dp[k][0] = Math.max(dptmp[k][1] + prices[i], dptmp[k][0]);
                dp[k][1] = dptmp[k - 1][0] == Integer.MIN_VALUE ?  Integer.MIN_VALUE : Math.max(dptmp[k][1], dptmp[k - 1][0] - prices[i]);
            }
        }
        return Math.max(dp[2][0], Math.max(dp[1][0], dp[0][0]));
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

    public static void main(String[] args) {
        int[] a = { 3,3,5,0,0,3,1,4 };
        System.out.println(new Q123_test1().maxProfit(a));
    }
}
