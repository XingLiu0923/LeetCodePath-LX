import java.util.ArrayList;
import java.util.List;

public class Q51_test1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        char[][] queenPans = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queenPans[i][j] = 'Q';
            }
        }
        DFS(queenPans, 0, n, solution);
        return solution;
    }

    private void DFS(char[][] queenPans, int row, int n, List<List<String>> solution) {
        for (int i = 0; i < n; i++) {
            List<Character> recordRow = new ArrayList<>();
            List<Character> recordCol = new ArrayList<>();
            List<Character> recordDia = new ArrayList<>();
            record(queenPans, row, i, n, recordRow, recordCol, recordDia);
            if (queenPans[row][i] == 'Q') {
                markUnQueen(queenPans, row, i, n);
                if (row == n - 1) {
                    List<String> list = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        list.add(String.valueOf(queenPans[j]));
                    }
                    solution.add(list);
                } else {
                    DFS(queenPans, row + 1, n, solution);
                }
            }
            recover(queenPans, row, i, n, recordRow, recordCol, recordDia);
        }
    }

    private void markUnQueen(char[][] queenPans, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            queenPans[row][i] = '.';
        }
        for (int i = 0; i < n; i++) {
            queenPans[i][col] = '.';
        }
        for (int i = row - 1, j = col - 1; i > -1 && j > -1; i--, j--) {
            queenPans[i][j] = '.';
        }
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            queenPans[i][j] = '.';
        }
        for (int i = row - 1, j = col + 1; i > -1 && j < n; i--, j++) {
            queenPans[i][j] = '.';
        }
        for (int i = row + 1, j = col - 1; i < n && j > -1; i++, j--) {
            queenPans[i][j] = '.';
        }
        queenPans[row][col] = 'Q';
    }

    private void record(char[][] queenPans, int row, int col, int n, List<Character> recordRow, List<Character> recordCol, List<Character> recordDia) {
        for (int j = 0; j < n; j++) {
            recordRow.add(queenPans[row][j]);
        }
        for (int i = 0; i < n; i++) {
            recordCol.add(queenPans[i][col]);
        }
        for (int i = row - 1, j = col - 1; i > -1 && j > -1; i--, j--) {
            recordDia.add(queenPans[i][j]);
        }
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            recordDia.add(queenPans[i][j]);
        }
        for (int i = row - 1, j = col + 1; i > -1 && j < n; i--, j++) {
            recordDia.add(queenPans[i][j]);
        }
        for (int i = row + 1, j = col - 1; i < n && j > -1; i++, j--) {
            recordDia.add(queenPans[i][j]);
        }
    }

    private void recover(char[][] queenPans, int row, int col, int n, List<Character> recordRow, List<Character> recordCol, List<Character> recordDia) {
        for (int j = 0; j < n; j++) {
            queenPans[row][j] = recordRow.get(j);
        }
        for (int i = 0; i < n; i++) {
            queenPans[i][col] = recordCol.get(i);
        }
        int count = 0;
        for (int i = row - 1, j = col - 1; i > -1 && j > -1; i--, j--) {
            queenPans[i][j] = recordDia.get(count++);
        }
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            queenPans[i][j] = recordDia.get(count++);
        }
        for (int i = row - 1, j = col + 1; i > -1 && j < n; i--, j++) {
            queenPans[i][j] = recordDia.get(count++);
        }
        for (int i = row + 1, j = col - 1; i < n && j > -1; i++, j--) {
            queenPans[i][j] = recordDia.get(count++);
        }
    }

    public static void main(String[] args) {
        new Q51_test1().solveNQueens(4);
    }
}
