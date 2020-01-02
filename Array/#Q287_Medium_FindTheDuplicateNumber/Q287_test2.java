public class Q287_test2 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 1, hi = n;
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (noMoreThanNumber(nums, mid) == mid) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int noMoreThanNumber(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) count++;
        }
        return count;
    }
}
