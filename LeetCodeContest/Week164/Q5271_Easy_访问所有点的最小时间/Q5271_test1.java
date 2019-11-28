public class Q5271_test1 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        int n = points.length;
        if (n == 1) return 0;
        for (int i = 1; i < n; i++) {
            sum = sum + secondsBetweenTwoPoints(points, i, i - 1);
        }
        return sum;
    }

    private int secondsBetweenTwoPoints(int[][] points, int i, int j) {
        return Math.max(Math.abs(points[i][0] - points[j][0]), Math.abs(points[i][1] - points[j][1]));
    }
}
