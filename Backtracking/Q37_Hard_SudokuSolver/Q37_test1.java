import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q37_test1 {
    public void solveSudoku(char[][] board) {
        List<int[]> blank = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') blank.add(new int[] {i, j});
            }
        }
        if (blank.isEmpty()) return;
        dfs(board, blank);
    }

    private boolean dfs(char[][] board, List<int[]> blank) {
        if (blank.isEmpty()) return true;
        int[] next = blank.remove(blank.size() - 1);
        List<Character> availList = availableNum(board, next[0], next[1]);
        if (availList.isEmpty()) { blank.add(next); return false; }
        for (char each : availList) {
            board[next[0]][next[1]] = each;
            if (dfs(board, blank)) return true;
        }
        board[next[0]][next[1]] = '.';
        blank.add(next);
        return false;
    }

    private List<Character> availableNum(char[][] board, int i, int j) {
        List<Character> list = new ArrayList<>();
        boolean[] availMark = new boolean[9];
        boolean[] wrongMark = new boolean[9];
        // 行里面检测；
        for (int col = 0; col < 9; col++) {
            int c = board[i][col];
            if (c == '.') continue;
            if (wrongMark[c - '1']) return list;
            wrongMark[c - '1'] = true;
            availMark[c - '1'] = true;
        }
        // 列里面检测；
        wrongMark = new boolean[9];
        for (int row = 0; row < 9; row++) {
            int c = board[row][j];
            if (c == '.') continue;
            if (wrongMark[c - '1']) return list;
            wrongMark[c - '1'] = true;
            availMark[c - '1'] = true;
        }
        // 方块里面检测；
        wrongMark = new boolean[9];
        int squareRow = i / 3 * 3, squareCol = j / 3 * 3;
        for (int row = squareRow; row < squareRow + 3; row++) {
            for (int col = squareCol; col < squareCol + 3; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (wrongMark[c - '1']) return list;
                wrongMark[c - '1'] = true;
                availMark[c - '1'] = true;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (!availMark[k]) list.add((char) ('1' + k));
        }
        return list;
    }
}
