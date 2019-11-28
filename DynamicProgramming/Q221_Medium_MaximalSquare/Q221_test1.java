public class Q221_test1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') { dp[i][j] = 0; continue; }
                else if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                if (dp[i][j] > maxLength) maxLength = dp[i][j];
            }
        }
        return (int)Math.pow(maxLength, 2);
    }
}
