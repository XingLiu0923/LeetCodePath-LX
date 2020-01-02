public class Q289_test1 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum8 = calculate(board, i, j);
                if (sum8 < 2) result[i][j] = 0;
                else if (sum8 == 2) result[i][j] = board[i][j];
                else if (sum8 == 3) result[i][j] = 1;
                else result[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    private int calculate(int[][] board, int row, int col) {
        int m = board.length, n = board[0].length, sum = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i > -1 && i < m && j > -1 && j < n)
                    sum += board[i][j];
            }
        }
        return sum - board[row][col];
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new Q289_test1().gameOfLife(a);
    }
}
