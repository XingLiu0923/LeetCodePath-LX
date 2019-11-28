public class Q256_test1 {
    public int minCost(int[][] costs) {
        int[] oddDP = new int[3];
        int[] evenDP = new int[3];
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenDP[0] = Math.min(oddDP[1], oddDP[2]) + costs[i][0];
                evenDP[1] = Math.min(oddDP[0], oddDP[2]) + costs[i][1];
                evenDP[2] = Math.min(oddDP[1], oddDP[0]) + costs[i][2];
            } else {
                oddDP[0] = Math.min(evenDP[1], evenDP[2]) + costs[i][0];
                oddDP[1] = Math.min(evenDP[0], evenDP[2]) + costs[i][1];
                oddDP[2] = Math.min(evenDP[1], evenDP[0]) + costs[i][2];
            }
        }
        if ((n - 1) % 2 == 0) return Math.min(evenDP[0], Math.min(evenDP[1], evenDP[2]));
        return Math.min(oddDP[0], Math.min(oddDP[1], oddDP[2]));
    }
}
