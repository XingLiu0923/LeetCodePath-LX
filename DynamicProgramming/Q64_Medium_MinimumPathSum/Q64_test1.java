public class Q64_test1 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] oddDP = new int[n];
        int[] evenDP = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (i == 0 && j == 0) evenDP[j] = grid[i][j];
                    else if (i == 0) evenDP[j] = evenDP[j - 1] + grid[i][j];
                    else if (j == 0) evenDP[j] = oddDP[j] + grid[i][j];
                    else evenDP[j] = Math.min(evenDP[j - 1], oddDP[j]) + grid[i][j];
                } else {
                    if (j == 0) oddDP[j] = evenDP[j] + grid[i][j];
                    else oddDP[j] = Math.min(oddDP[j - 1], evenDP[j]) + grid[i][j];
                }
            }
        }
        if ((m - 1) % 2 == 0) return evenDP[n - 1];
        else return oddDP[n - 1];
    }
}
