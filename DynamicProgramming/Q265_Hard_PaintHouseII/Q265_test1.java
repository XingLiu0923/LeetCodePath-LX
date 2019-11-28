public class Q265_test1 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        int[] oddDP = new int[k];
        int[] evenDP = new int[k];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < k; j++) {
                    evenDP[j] = minExceptK(oddDP, j) + costs[i][j];
                }
            } else {
                for (int j = 0; j < k; j++) {
                    oddDP[j] = minExceptK(evenDP, j) + costs[i][j];
                }
            }
        }
        if ((n - 1) % 2 == 0) return minExceptK(evenDP, -1);
        return minExceptK(oddDP, -1);
    }

    private int minExceptK(int[] a, int k) {
        int min = Integer.MAX_VALUE;
        if (a.length == 1 && k == 0) return 0;
        for (int i = 0; i < k; i++) {
            if (a[i] < min) min = a[i];
        }
        for (int i = k + 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] a = new int[1][1];
        a[0][0] = 8;
        new Q265_test1().minCostII(a);
    }
}
