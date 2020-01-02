public class Q209_test1 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int j = 0;
        int maxGap = 0;
        for (int i = 0; i < n + 1; i++) {
            while (j < n + 1 && sums[j] - sums[i] < s) j++;
            if (j == n + 1) break;
            if (maxGap == 0 || j - i < maxGap) maxGap = j - i;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2,3,1,2,4,3};
        new Q209_test1().minSubArrayLen(7, a);
    }
}
