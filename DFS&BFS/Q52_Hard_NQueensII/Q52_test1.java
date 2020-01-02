public class Q52_test1 {
    private int solution;
    private boolean[] cols;
    private boolean[] leftUp;
    private boolean[] rightUp;
    private int n;

    public int totalNQueens(int n) {
        solution = 0;
        cols = new boolean[n];
        leftUp = new boolean[2 * n];
        rightUp = new boolean[2 * n];
        this.n = n;
        DFS(0);
        return solution;
    }

    private void DFS(int row) {
        for (int i = 0; i < n; i++) {
            if (couldBeQueen(row, i)) {
                addQueue(row, i);
                if (row == n - 1) solution++;
                else DFS(row + 1);
                deleQueen(row, i);
            }
        }
    }

    private boolean couldBeQueen(int row, int col) {
        return !cols[col] && !leftUp[(row - col + 2 * n) % (2*n)] && !rightUp[row + col];
    }

    private void addQueue(int row, int col) {
        cols[col] = leftUp[(row - col + 2 * n) % (2*n)] = rightUp[row + col] = true;
    }

    private void deleQueen(int row, int col) {
        cols[col] = leftUp[(row - col + 2 * n) % (2*n)] = rightUp[row + col] = false;
    }
}
