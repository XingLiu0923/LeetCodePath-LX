public class Q79_test1 {
    public boolean exist(char[][] board, String word) {
        int m = board.length; if (m == 0) return false;
        int n = board[0].length;
        int wordLen = word.length(); if (wordLen == 0) return true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int p) {
        if (p == word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] != word.charAt(p)) return false;
        char c = board[i][j];
        board[i][j] = '.';
        if (dfs(board, i + 1, j, word, p + 1)) return true;
        if (dfs(board, i - 1, j, word, p + 1)) return true;
        if (dfs(board, i, j - 1, word,p + 1)) return true;
        if (dfs(board, i, j + 1, word, p + 1)) return true;
        board[i][j] = c;
        return false;
    }
}
