public class Q171_4_test1 {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 0; dp[1][0] = 0;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (j != i - 1) dp[i][j] = dp[i - 1][j] + distance(word.charAt(i - 1), word.charAt(i - 2));
                else {
                    int minDis = Integer.MAX_VALUE;
                    for (int col = 0; col < j; col++) {
                        int rightDist = (col == 0) ? 0 : (distance(word.charAt(i - 1), word.charAt(col - 1)));
                        int dist = dp[i - 1][col] + rightDist;
                        if (dist < minDis) minDis = dist;
                    }
                    dp[i][j] = minDis;
                }
            }
        }
        int minDis = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minDis = Math.min(minDis, dp[n][j]);
        }
        return minDis;
    }

    private int distance(char i, char j) {
        int[] posI = cordi(i);
        int[] posJ = cordi(j);
        return Math.abs(posI[0] - posJ[0]) + Math.abs(posI[1] - posJ[1]);
    }

    private int[] cordi(char c) {
        int[] pos = new int[2];
        pos[0] = (c - 'A') / 6;
        pos[1] = (c - 'A') % 6;
        return pos;
    }
}
