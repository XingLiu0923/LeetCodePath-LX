public class Q377_test1 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i + nums[j] <= target) dp[i + nums[j]] += dp[i];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        new Q377_test1().combinationSum4(a, 3);
    }
}
