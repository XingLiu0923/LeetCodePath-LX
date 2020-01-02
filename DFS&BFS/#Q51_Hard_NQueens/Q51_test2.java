import java.util.ArrayList;
import java.util.List;

public class Q51_test2 {
    private int[] rows;
    private boolean[] cols;
    private boolean[] leftUp;
    private boolean[] rightUp;
    private List<List<String>> solution;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        rows = new int[n];
        cols = new boolean[n];
        leftUp = new boolean[2 * n];
        rightUp = new boolean[2 * n];
        solution = new ArrayList<>();
        this.n = n;
        for (int i = 0; i < n; i++) {
            rows[i] = -1;
        }
        DFS(0);
        return solution;
    }

    private void DFS(int row) {
        for (int i = 0; i < n; i++) {
            if (couldBeQueen(row, i)) {
                addQueen(row, i);
                if (row == n - 1) {
                    addSolution();
                } else {
                    DFS(row + 1);
                }
                deleQueen(row, i);
            }
        }
    }

    private boolean couldBeQueen(int row, int col) {
        return !cols[col] && !leftUp[(row - col + 2 * n) % (2 * n)] && !rightUp[row + col];
    }

    private void addQueen(int row, int col) {
        rows[row] = col;
        cols[col] = leftUp[(row - col + 2 * n) % (2 * n)] = rightUp[row + col] = true;
    }

    private void deleQueen(int row, int col) {
        rows[row] = -1;
        cols[col] = leftUp[(row - col + 2 * n) % (2 * n)] = rightUp[row + col] = false;
    }

    private void addSolution() {
        char[][] pans = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                pans[i][j] = '.';
        }
        for (int i = 0; i < n; i++) {
            pans[i][rows[i]] = 'Q';
        }
        List<String> thisSolution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            thisSolution.add(String.valueOf(pans[i]));
        }
        solution.add(thisSolution);
    }

    public static void main(String[] args) {
        new Q51_test2().solveNQueens(4);
    }
}
