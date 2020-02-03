public class Q174_4_test1 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            // boolean[] visited = new boolean[n];
            if (dp[i] == 0) dfs(arr, i, d, dp);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private void dfs(int[] arr, int i, int d, int[] dp) {
        int n = arr.length;
        for (int j = i + 1; j <= i + d; j++) {
            if (j < n) {
                if (arr[j] >= arr[i]) break;
                if (dp[j] == 0) dfs(arr, j, d, dp);
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        for (int j = i - 1; j >= i - d; j--) {
            if (j > -1) {
                if (arr[j] >= arr[i]) break;
                if (dp[j] == 0) dfs(arr, j, d, dp);
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        dp[i] = Math.max(dp[i], 1);
    }

    public static void main(String[] args) {
        new Q174_4_test1().maxJumps(new int[] {6,4,14,6,8,13,9,7,10,6,12}, 2);
    }
}
