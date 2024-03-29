class NumMatrix1 {

    private int[][] dp;

    public NumMatrix1(int[][] matrix) {
        int m = matrix.length; if (m == 0) return;
        int n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] += matrix[i][j];
                if (i - 1 >= 0) dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0) dp[i][j] -= dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = dp[row2][col2];
        if (row1 - 1 >= 0) sum -= dp[row1 - 1][col2];
        if (col1 - 1 >= 0) sum -= dp[row2][col1 - 1];
        if (row1 - 1 >= 0 && col1 - 1 >= 0) sum += dp[row1 - 1][col1 - 1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */