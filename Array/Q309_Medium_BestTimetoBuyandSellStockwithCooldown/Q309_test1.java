public class Q309_test1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int dpsel = 0;
        int dphold = -prices[0];
        int dpcool = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int tmpsel = dpsel, tmphold = dphold, tmpcool = dpcool;
            dpsel = Math.max(tmpsel, tmpcool);
            dpcool = tmphold + prices[i];
            dphold = Math.max(tmphold, tmpsel - prices[i]);
        }
        return Math.max(dpsel, dpcool);
    }
}
