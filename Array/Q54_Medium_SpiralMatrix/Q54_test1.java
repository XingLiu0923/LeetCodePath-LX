import java.util.ArrayList;
import java.util.List;

public class Q54_test1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> path = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return path;
        int n = matrix[0].length;
        boolean[][] mark = new boolean[m][n];
        dfs(matrix, path, mark, 0, 0, m, n);
        return path;
    }

    private void dfs(int[][] matrix, List<Integer> path, boolean[][] mark, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || mark[i][j]) return;
        path.add(matrix[i][j]); mark[i][j] = true;
        if ((i - 1 < 0 || mark[i - 1][j]) && (j - 1 < 0 || mark[i][j - 1])) dfs(matrix, path, mark, i, j + 1, m, n);
        if ((i - 1 < 0 || mark[i - 1][j]) && (j + 1 >= n || mark[i][j + 1])) dfs(matrix, path, mark, i + 1, j, m, n);
        if ((i + 1 >= m || mark[i + 1][j]) || (j + 1 >= n) || mark[i][j + 1]) dfs(matrix, path, mark, i, j - 1, m, n);
        if ((i + 1 >= m || mark[i + 1][j]) || (j - 1 < 0 || mark[i][j - 1])) dfs(matrix, path, mark, i - 1, j, m, n);
    }
}
