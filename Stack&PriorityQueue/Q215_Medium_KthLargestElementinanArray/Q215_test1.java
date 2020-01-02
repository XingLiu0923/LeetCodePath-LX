import java.util.Arrays;
import java.util.Collections;

public class Q215_test1 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (mid < k - 1) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int n = nums.length;
        for (int j = lo + 1; j < hi; j++) {
            if (nums[j] >= nums[lo]) swap(nums, ++i, j);
        }
        swap(nums, lo, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        new Q215_test1().findKthLargest(a, 2);
    }
}
