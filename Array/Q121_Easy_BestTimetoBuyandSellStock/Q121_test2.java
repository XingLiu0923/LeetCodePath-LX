public class Q121_test2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int lowestPrice = prices[0];
        int highestProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < lowestPrice) lowestPrice = prices[i];
            else if (prices[i] - lowestPrice > highestProfit) highestProfit = prices[i] - lowestPrice;
        }
        return highestProfit;
    }
}
