import java.util.*;

public class Q173_3_test1 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long[][] shortestDist = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) shortestDist[i][j] = 0;
                else shortestDist[i][j] = Integer.MAX_VALUE;
            }
        }
        int edgeNum = edges.length;
        for (int i = 0; i < edgeNum; i++) {
            shortestDist[edges[i][0]][edges[i][1]] = edges[i][2];
            shortestDist[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    shortestDist[i][j] = Math.min(shortestDist[i][j], shortestDist[i][k] + shortestDist[j][k]);
                }
            }
        }
        int minP = n - 1;
        int minNum = Integer.MAX_VALUE;
        for (int i = n - 1; i > -1; i--) {
            int num = 0;
            for (int j = n - 1; j > -1; j--) {
                if (shortestDist[i][j] <= distanceThreshold) num++;
            }
            if (num < minNum) {
                minNum = num;
                minP = i;
            }
        }
        return minP;
    }

    public static void main(String[] args) {
        new Q173_3_test1().findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2);
    }
}
