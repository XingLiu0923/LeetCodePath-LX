import java.util.LinkedList;
import java.util.Queue;

public class Q317_test1 {
    public int shortestDistance(int[][] grid) {
        int m = grid.length; if (m == 0) return -1;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        if (count == m * n) return -1;
        boolean[][] meetRequire = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int[] arrive = new int[]{0};
                    boolean[][] visited = new boolean[m][n];
                    bfs(grid, i, j, res, visited, arrive);
                    if (arrive[0] == count) meetRequire[i][j] = true;
                }
            }
        }
        int minRes = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (meetRequire[i][j]) minRes = Math.min(minRes, res[i][j]);
            }
        }
        if (minRes == Integer.MAX_VALUE) return -1;
        return minRes;
    }

    private void bfs(int[][] grid, int i, int j, int[][] res, boolean[][] visited, int[] arrive) {
        int m = grid.length, n = grid[0].length;
        int[] root = new int[] {i, j, 0};
        visited[i][j] = true;
        Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int[] curPos = nodeQueue.poll();
            int row = curPos[0], col = curPos[1], val = curPos[2];
            if (row - 1 > -1 && !visited[row - 1][col]) {
                dealPos(grid, row - 1, col, i, j, val, res, visited, nodeQueue, arrive);
            }
            if (row + 1 < m && !visited[row + 1][col]) {
                dealPos(grid, row + 1, col, i, j, val, res, visited, nodeQueue, arrive);
            }
            if (col - 1 > -1 && !visited[row][col - 1]) {
                dealPos(grid, row, col - 1, i, j, val, res, visited, nodeQueue, arrive);
            }
            if (col + 1 < n && !visited[row][col + 1]) {
                dealPos(grid, row, col + 1, i, j, val, res, visited, nodeQueue, arrive);
            }
        }
    }

    private void dealPos(int[][] grid, int i, int j, int originI, int originJ, int val, int[][] res, boolean[][] visited, Queue<int[]> nodeQueue, int[] arrive) {
        if (grid[i][j] == 1) {
            res[originI][originJ] += (val + 1);
            arrive[0]++;
        } else if (grid[i][j] == 0) {
            nodeQueue.add(new int[] {i, j, val + 1});
        }
        visited[i][j] = true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1,2,0}
        };
        new Q317_test1().shortestDistance(grid);
    }
}
