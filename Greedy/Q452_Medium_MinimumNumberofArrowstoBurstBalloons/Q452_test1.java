import java.util.Arrays;

public class Q452_test1 {
    public int findMinArrowShots(int[][] points) {
        int n = points.length; if (n == 0) return 0;
        Arrays.sort(points, (o1, o2) -> (o1[1] - o2[1]));
        int ends = points[0][1], count = 1;
        for (int i = 1; i < n; i++) {
            if (points[i][0] > ends) {
                count++;
                ends = points[i][1];
            }
        }
        return count;
    }
}
