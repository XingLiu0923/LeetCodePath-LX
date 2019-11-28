public class Q63_test1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] rowsA = new int[m];
        boolean mark = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) mark = true;
            rowsA[i] = mark ? 0 : 1;
        }
        int[] rowsB = new int[m];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowsB[j] = (j == 0) ? (obstacleGrid[i][j] == 1 ? 0 : rowsA[j]) : (obstacleGrid[i][j] == 1 ? 0 : rowsA[j] + rowsB[j - 1]);
                rowsA[j] = rowsB[j];
            }
        }
        return rowsA[m - 1];
    }
}
