public class Q329_test1 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length; if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] nextPos = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) dfs(matrix, i, j, nextPos, dp);
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private void dfs(int[][] matrix, int i, int j, int[][] nextPos, int[][] dp) {
        int m = matrix.length, n = matrix[0].length;
        for (int[] each : nextPos) {
            int nextRow = i + each[0], nextCol = j + each[1];
            if (nextRow > -1 && nextRow < m && nextCol > -1 && nextCol < n) {
                if (matrix[nextRow][nextCol] > matrix[i][j]) {
                    if (dp[nextRow][nextCol] == 0) dfs(matrix, nextRow, nextCol, nextPos, dp);
                    dp[i][j] = Math.max(dp[i][j], dp[nextRow][nextCol] + 1);
                }
            }
        }
        dp[i][j] = Math.max(dp[i][j], 1);
    }
}
