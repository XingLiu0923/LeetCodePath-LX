import java.util.HashMap;

public class Q149_test1 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 1) return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int pointMax = 1;
            int same = 0;
            HashMap<String, Integer> line = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                    same++;
                    continue;
                }
                String k = getK(points[i], points[j]);
                if (!line.containsKey(k)) line.put(k, 1);
                int num = line.get(k);
                num++;
                if (num > pointMax) pointMax = num;
                line.put(k, num);
            }
            if (pointMax + same > max) max = pointMax + same;
        }
        return max;
    }

    private String getK(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) return "inf@1";
        if (p1[1] == p2[1]) return "0@1";
        int gcd = gcd(p1[1] - p2[1], p1[0] - p2[0]);
        int n = (p2[1] - p1[1]) / gcd;
        int m = (p2[0] - p1[0]) / gcd;
        if (m < 0) { n = -n; m = -m; }
        return n + "@" + m;
    }

    private int gcd(int a, int b) {
        int result = b == 0 ? a : gcd(b, a  % b);
        return result;
    }

    public static void main(String[] args) {
        int[][] p = new int[][] {{3, 2}, {4, 1}, {1, 4}, {2, 3}};
        new Q149_test1().maxPoints(p);
    }
}
