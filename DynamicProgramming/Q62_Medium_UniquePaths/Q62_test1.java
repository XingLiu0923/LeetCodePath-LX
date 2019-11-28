public class Q62_test1 {
    public int uniquePaths(int m, int n) {
        int[] rowsa = new int[m];
        for (int i = 0; i < m; i++) {
            rowsa[i] = 1;
        }
        int[] rowsb = new int[m];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowsb[j] = (j == 0) ? rowsa[j] : rowsa[j] + rowsb[j - 1];
                rowsa[j] = rowsb[j];
            }
        }
        return rowsa[m - 1];
    }
}
