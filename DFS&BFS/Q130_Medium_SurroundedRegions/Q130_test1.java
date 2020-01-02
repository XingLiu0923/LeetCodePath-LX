public class Q130_test1 {
    public void solve(char[][] board) {
        int m = board.length; if (m == 0) return;
        int n = board[0].length;
        boolean[][] mark = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !mark[0][j]) DFS(board, 0, j, mark);
        }
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O' && !mark[m - 1][j]) DFS(board, m - 1, j, mark);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !mark[i][0]) DFS(board, i, 0, mark);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O' && !mark[i][n - 1]) DFS(board, i, n - 1, mark);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !mark[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void DFS(char[][] board, int i, int j, boolean[][] mark) {
        int m = board.length; int n = board[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || mark[i][j] || board[i][j] == 'X') return;
        mark[i][j] = true;
        DFS(board, i - 1, j, mark);
        DFS(board, i + 1, j, mark);
        DFS(board, i, j - 1, mark);
        DFS(board, i, j + 1, mark);
    }
}
