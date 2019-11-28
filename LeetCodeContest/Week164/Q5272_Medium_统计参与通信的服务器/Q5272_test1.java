public class Q5272_test1 {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            int colMark = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { rowSum++; colMark = j;}
            }
            if (rowSum > 1) sum = sum + rowSum;
            else if (rowSum == 1) {
                for (int k = 0; k < m; k++) {
                    if (k != i && grid[k][colMark] == 1) {
                        sum++;
                        break;
                    }
                }
            }
        }
        return sum;

    }
}
