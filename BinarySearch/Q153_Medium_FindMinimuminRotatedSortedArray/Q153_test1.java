public class Q153_test1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int mark = nums[0];
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= mark) lo = mid + 1;
            else hi = mid;
        }
        if (lo > -1 && lo < n) return nums[lo];
        return mark;
    }
}
