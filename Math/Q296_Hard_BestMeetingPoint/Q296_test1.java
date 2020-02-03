import java.util.Collections;
import java.util.Vector;

public class Q296_test1 {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length; if (m == 0) return 0;
        int n = grid[0].length;
        Vector<Integer> rowVector = new Vector<>();
        Vector<Integer> colVector = new Vector<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) rowVector.add(i);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) colVector.add(j);
            }
        }
        int resRow = rowVector.get(rowVector.size() / 2);
        int resCol = colVector.get(colVector.size() / 2);
        int dist = calcDist(grid, resRow, resCol);
        return dist;
    }

    private int calcDist(int[][] grid, int resRow, int resCol) {
        int sum = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) sum += (Math.abs(i - resRow) + Math.abs(j - resCol));
            }
        }
        return sum;
    }
}
