import java.util.*;

public class Q166_4_test1 {
    public int minFlips(int[][] mat) {
        HashMap<String, Integer> matrixMap = new HashMap<>();
        int m = mat.length; if (m == 0) return -1;
        int n = mat[0].length;
        Queue<int[][]> q = new LinkedList<>();
        int clock = 0;
        q.add(mat);
        matrixMap.put(MatrixToString(mat), clock);
        while (!q.isEmpty()) {
            int[][] tmp = q.remove();
            String s = MatrixToString(tmp);
            clock = matrixMap.get(s);
            if (isZero(tmp)) return clock;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int[][] tmpNeighbor = neighbor(tmp, i, j);
                    String ns = MatrixToString(tmpNeighbor);
                    if (!matrixMap.containsKey(ns)) {
                        matrixMap.put(ns, clock + 1);
                        q.add(tmpNeighbor);
                    }
                }
            }
        }
        return -1;
    }

    private boolean isZero(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) return false;
            }
        }
        return true;
    }

    private int[][] neighbor(int[][] mat, int k, int l) {
        int m = mat.length, n = mat[0].length;
        int[][] neighborMat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == k - 1 && j == l)
                    || (i == k + 1 && j == l)
                    || (j == l - 1 && i == k)
                    || (j == l + 1 && i == k)
                    || (i == k && j == l))
                    neighborMat[i][j] = 1 - mat[i][j];
                else neighborMat[i][j] = mat[i][j];
            }
        }
        return neighborMat;
    }

    private String MatrixToString(int[][] mat) {
        String s = "";
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                s = s + mat[i][j];
            }
        }
        return s;
    }
}
