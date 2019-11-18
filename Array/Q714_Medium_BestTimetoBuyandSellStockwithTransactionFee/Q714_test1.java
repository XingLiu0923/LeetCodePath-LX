public class Q714_test1 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2) return 0;
        int dpsel = 0;
        int dphold = -prices[0];
        for (int i = 0; i < n; i++) {
            int tmpsel = dpsel, tmphold = dphold;
            dpsel = Math.max(tmphold + prices[i] - fee, tmpsel);
            dphold = Math.max(tmpsel - prices[i], tmphold);
        }
        return Math.max(dpsel, dphold);
    }
}
