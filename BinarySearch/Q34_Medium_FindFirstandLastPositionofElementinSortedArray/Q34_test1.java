public class Q34_test1 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        result[0] = -1; result[1] = -1;
        if (n == 0) return result;

        int lo = -1, hi = n - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        if (lo < 0 || lo > n - 1 || nums[lo] != target) return result;
        result[1] = hi;

        lo = 0; hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        result[0] = lo;

        return result;
    }
}
