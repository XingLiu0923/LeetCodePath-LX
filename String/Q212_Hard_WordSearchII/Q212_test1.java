import java.util.ArrayList;
import java.util.List;

public class Q212_test1 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsList = new ArrayList<>();
        if (words.length == 0 || board.length == 0 || board[0].length == 0) return wordsList;
        for (String word : words) {
            if (findWords(board, word)) wordsList.add(word);
        }
        return wordsList;
    }

    private boolean findWords(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] mark = new boolean[m][n];
                if (findWordsDFS(board, i, j, word, 0, mark)) return true;
            }
        }
        return false;
    }

    private boolean findWordsDFS(char[][] board, int i, int j, String word, int begin, boolean[][] mark) {
        if (board[i][j] != word.charAt(begin)) return false;    // mark true在下面，不用担心变成true的问题。
        if (begin == word.length() - 1) return true;
        mark[i][j] = true;
        int m = board.length, n = board[0].length;
        if (i - 1 >= 0 && !mark[i - 1][j]) {
            if (findWordsDFS(board, i - 1, j, word, begin + 1, mark)) return true;
        }
        if (i + 1 <= m - 1 && !mark[i + 1][j]) {
            if (findWordsDFS(board, i + 1, j, word, begin + 1, mark)) return true;
        }
        if (j - 1 >= 0 && !mark[i][j - 1]) {
            if (findWordsDFS(board, i, j - 1, word, begin + 1, mark)) return true;
        }
        if (j + 1 <= n - 1 && !mark[i][j + 1]) {
            if (findWordsDFS(board, i, j + 1, word, begin + 1, mark)) return true;
        }
        mark[i][j] = false;
        return false;
    }
}
