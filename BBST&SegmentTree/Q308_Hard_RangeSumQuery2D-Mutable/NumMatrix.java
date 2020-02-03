class NumMatrix {

    private int[][] C;
    private int[][] matrix;
    int m, n;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        if (m == 0) return;
        n = matrix[0].length;
        this.m = m; this.n = n;
        C = new int[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] += matrix[i - 1][j - 1];
                if (i - 1 > 0) dp[i][j] += dp[i - 1][j];
                if (j - 1 > 0) dp[i][j] += dp[i][j - 1];
                if (i - 1 > 0 && j - 1 > 0) dp[i][j] -= dp[i - 1][j - 1];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                C[i][j] = dp[i][j] - dp[i - lowbit(i)][j] - dp[i][j - lowbit(j)] + dp[i - lowbit(i)][j - lowbit(j)];
            }
        }
    }

    public void update(int row, int col, int val) {
        int gap = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = row + 1; i <= m; i += lowbit(i)) {
            for (int j = col + 1; j <= n; j += lowbit(j)) {
                C[i][j] += gap;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(row2 + 1, col2 + 1) - sumRegion(row1, col2 + 1) - sumRegion(row2 + 1, col1) + sumRegion(row1, col1);
    }

    private int sumRegion(int row, int col) {
        int res = 0;
        for (int i = row; i > 0; i -= lowbit(i)) {
            for (int j = col; j > 0; j -= lowbit(j)) {
                res += C[i][j];
            }
        }
        return res;
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) {
        System.out.print(1 & -1);
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        numMatrix.sumRegion(2, 1, 4, 3);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */