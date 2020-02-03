public class Q132_test1 {
    public int minCut(String s) {
        int n = s.length();
        if (n == 0) return 0;
        boolean[][] dpIsPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) dpIsPalin[i][i] = true;
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                if (s.charAt(i) == s.charAt(i + gap)) {
                    if (gap == 1) dpIsPalin[i][i + gap] = true;
                    else dpIsPalin[i][i + gap] = dpIsPalin[i + 1][i + gap - 1];
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dpIsPalin[j][i]) {
                    if (j == 0) { dp[i] = 0; break; }
                    else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
