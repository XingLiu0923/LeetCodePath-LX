import java.util.LinkedList;
import java.util.Queue;

public class Q286_test1 {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length; if (m == 0) return;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) BFS(rooms, i, j);
            }
        }
    }

    private void BFS(int[][] rooms, int i, int j) {
        Queue<int[]> posQ = new LinkedList<>();
        int[] pos = {i, j};
        posQ.add(pos);
        int m = rooms.length, n = rooms[0].length;
        while (!posQ.isEmpty()) {
            int[] cur = posQ.poll();
            int row = cur[0], col = cur[1];
            int curNum = rooms[row][col];
            if (row - 1 > -1 && rooms[row - 1][col] > 0 && rooms[row - 1][col] > curNum + 1) {
                rooms[row - 1][col] = curNum + 1;
                int[] neighbor = {row - 1, col};
                posQ.add(neighbor);
            }
            if (row + 1 < m && rooms[row + 1][col] > 0 && rooms[row + 1][col] > curNum + 1) {
                rooms[row + 1][col] = curNum + 1;
                int[] neighbor = {row + 1, col};
                posQ.add(neighbor);
            }
            if (col - 1 > -1 && rooms[row][col - 1] > 0 && rooms[row][col - 1] > curNum + 1) {
                rooms[row][col - 1] = curNum + 1;
                int[] neighbor = {row, col - 1};
                posQ.add(neighbor);
            }
            if (col + 1 < n && rooms[row][col + 1] > 0 && rooms[row][col + 1] > curNum + 1) {
                rooms[row][col + 1] = curNum + 1;
                int[] neighbor = {row, col + 1};
                posQ.add(neighbor);
            }
        }
    }
}
