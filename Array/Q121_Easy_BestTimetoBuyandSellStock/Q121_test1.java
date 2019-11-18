public class Q121_test1 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] diff = new int[prices.length - 1];
        int n = diff.length;
        // 构造新的数组，为相邻两数的差；
        for (int i = 0; i < n; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int max = diff[0]; int sum = diff[0];
        for (int i = 1; i < n; i++) {
            if (sum < 0 || sum + diff[i] < 0) sum = diff[i];        // 若sum本身小于0，则可以放弃，因为加上后面的数肯定更小，并且之前的最大值已经记录在max中；sum + diff[i] < 0同理；
            else sum = sum + diff[i];
            if (sum > max) max = sum;       // 比较当前可能的最大值和存储的最大值的大小；
        }
        if (max < 0) return 0;
        return max;
    }
}
