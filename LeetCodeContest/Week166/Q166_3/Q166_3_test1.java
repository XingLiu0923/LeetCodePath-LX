public class Q166_3_test1 {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 0; int hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == 0) return 1;
            if (!isOK(nums, mid, threshold)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private boolean isOK(int[] nums, int k, int threshhold) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum = sum + (nums[i] % k == 0 ? nums[i]/k : (nums[i]/k + 1));
        }
        return sum <= threshhold;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Q166_3_test1().smallestDivisor(nums, 6);
    }
}
