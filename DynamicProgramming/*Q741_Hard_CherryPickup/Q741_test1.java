public class Q741_test1 {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = Math.max(0, i + j - n + 1); k < Math.min(i + j + 1, n); k++) {
                    if (grid[i][j] == -1 || grid[k][i + j - k] == -1) dp[i][j][k] = -1;
                    else if (i == 0 && j == 0) dp[i][j][k] = grid[i][j];
                    else if (i == 0) {
                        if (i == k) {
                            if (dp[i][j - 1][k] == -1) dp[i][j][k] = -1;
                            else dp[i][j][k] = dp[i][j - 1][k] + grid[i][j];
                        }
                        else {
                            if (dp[i][j - 1][k - 1] == -1 && dp[i][j - 1][k] == -1) dp[i][j][k] = -1;
                            else dp[i][j][k] = Math.max(dp[i][j - 1][k - 1], dp[i][j - 1][k]) + grid[i][j] + grid[k][i + j - k];
                        }
                    }
                    else if (j == 0) {
                        if (k == 0) {
                            if (dp[i - 1][j][k] == -1) dp[i][j][k] = -1;
                            else dp[i][j][k] = dp[i - 1][j][k] + grid[i][j] + grid[k][i + j -k];
                        }
                        else if (i == k) {
                            if (dp[i - 1][j][k - 1] == -1 && dp[i - 1][j][k] == -1) dp[i][j][k] = -1;
                            else dp[i][j][k] = Math.max(dp[i - 1][j][k - 1], dp[i - 1][j][k]) + grid[i][j];
                        }
                        else {
                            if (dp[i - 1][j][k - 1] == -1 && dp[i - 1][j][k] == -1) dp[i][j][k] = -1;
                            else dp[i][j][k] = Math.max(dp[i - 1][j][k - 1], dp[i - 1][j][k]) + grid[i][j] + grid[k][i + j -k];
                        }
                    }
                    else {
                        int dp1 = k == 0 ? -1 : dp[i - 1][j][k - 1];
                        int dp2 = dp[i - 1][j][k];
                        int dp3 = k == 0 ? -1 : dp[i][j - 1][k - 1];
                        int dp4 = dp[i][j - 1][k];
                        if (dp1 == -1 && dp3 == -1 && dp2 == -1 && dp4 == -1) dp[i][j][k] = -1;
                        else {
                            int dpMax = Math.max(dp1, Math.max(dp2, Math.max(dp3, dp4)));
                            dp[i][j][k] = ((i == k ? grid[i][j] : (grid[i][j] + grid[k][i + j - k])) + dpMax);
                        }
                    }
                }
            }
        }
        if (dp[n - 1][n - 1][n - 1] == -1) return 0;
        return dp[n - 1][n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        new Q741_test1().cherryPickup(a);
    }

}
