public class Q59_test1 {
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[n][n];
        int[][] matrix = new int[n][n];
        int row_lo = 0, row_hi = n, col_lo = 0, col_hi = n;
        int count = 1;
        while (count < n * n + 1) {
            if (col_lo >= col_hi) break;
            for (int i = col_lo; i < col_hi; i++) matrix[row_lo][i] = count++;
            row_lo++;

            if (row_lo >= row_hi) break;
            for (int i = row_lo; i < row_hi; i++) matrix[i][col_hi - 1] = count++;
            col_hi--;

            if (col_hi <= col_lo) break;
            for (int i = col_hi - 1; i >= col_lo; i--) matrix[row_hi - 1][i] = count++;
            row_hi--;

            if (row_hi <= row_lo) break;
            for (int i = row_hi - 1; i >= row_lo; i--) matrix[i][col_lo] = count++;
            col_lo++;
        }
        return matrix;
    }
}
