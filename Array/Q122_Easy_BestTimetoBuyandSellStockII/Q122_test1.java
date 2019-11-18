public class Q122_test1 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] diff = new int[prices.length - 1];
        int n = diff.length;
        // 构造新的数组，为相邻两数的差；
        for (int i = 0; i < n; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] > 0) sum = sum + diff[i];
        }
        return sum;
    }
}
