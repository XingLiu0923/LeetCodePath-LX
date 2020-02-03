public class Q36_test1 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowMark = new boolean[9][9];
        boolean[][] colMark = new boolean[9][9];
        boolean[][][] squareMark = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (rowMark[i][num] || colMark[j][num] || squareMark[i / 3][j / 3][num]) return false;
                rowMark[i][num] = true;
                colMark[j][num] = true;
                squareMark[i / 3][j / 3][num] = true;
            }
        }
        return true;
    }
}
