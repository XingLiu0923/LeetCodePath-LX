public class Q48_test1 {
    public void rotate(int[][] matrix) {
        mirror(matrix);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void mirror(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int j = 0, k = n - 1;
            while (j < k) swap(matrix, j++, i, k--, i);
        }
    }

    private void swap(int[][] matrix, int i1, int i2, int j1, int j2) {
        int t = matrix[i1][i2];
        matrix[i1][i2] = matrix[j1][j2];
        matrix[j1][j2] = t;
    }
}
