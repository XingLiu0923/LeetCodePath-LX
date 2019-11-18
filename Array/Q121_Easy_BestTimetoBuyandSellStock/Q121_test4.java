public class Q121_test4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int dpsel = 0;
        int dphold = -prices[0];
        for (int i = 1; i < n; i++) {
            int tmpdpsel = dpsel; int tmpdphold = dphold;
            dpsel = Math.max(tmpdpsel, tmpdphold + prices[i]);
            dphold = Math.max(tmpdphold, - prices[i]);
        }
        return dpsel;
    }
}
