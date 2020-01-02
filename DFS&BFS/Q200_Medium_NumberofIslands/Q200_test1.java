public class Q200_test1 {
    public int numIslands(char[][] grid) {
        int m = grid.length; if (m == 0);   if (m == 0) return 0;
        int n = grid[0].length;
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mark[i][j] = false;
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !mark[i][j]) {
                    DFS(grid, i, j, mark);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void DFS(char[][] grid, int i, int j, boolean[][] mark) {
        mark[i][j] = true;
        int m = grid.length, n = grid[0].length;
        if (i - 1 > -1 && grid[i - 1][j] == '1' && !mark[i - 1][j]) DFS(grid, i - 1, j, mark);
        if (i + 1 < m && grid[i + 1][j] == '1' && !mark[i + 1][j]) DFS(grid, i + 1, j, mark);
        if (j - 1 > -1 && grid[i][j - 1] == '1' && !mark[i][j - 1]) DFS(grid, i, j - 1, mark);
        if (j + 1 < n && grid[i][j + 1] == '1' && !mark[i][j + 1]) DFS(grid, i, j + 1, mark);
    }
}
