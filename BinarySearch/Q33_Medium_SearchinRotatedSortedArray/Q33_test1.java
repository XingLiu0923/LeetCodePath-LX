public class Q33_test1 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int mark = nums[0];
        int lo = 0, hi = n;
        if (target >= mark) {
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < mark) hi = mid;
                else {
                    if (nums[mid] < target) lo = mid + 1;
                    else hi = mid;
                }
            }
        } else {
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] >= mark) lo = mid + 1;
                else {
                    if (nums[mid] < target) lo = mid + 1;
                    else hi = mid;
                }
            }
        }
        if (lo > -1 && lo < n && nums[lo] == target) return lo;
        return -1;
    }
}
