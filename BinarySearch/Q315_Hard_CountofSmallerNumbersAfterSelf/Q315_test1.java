import java.util.ArrayList;
import java.util.List;

public class Q315_test1 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> countList = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return countList;
        int[] count = new int[n];
        mergeCount(nums, count, 0, n);
        for (int i = 0; i < n; i++) {
            countList.add(count[i]);
        }
        return countList;
    }

    private void mergeCount(int[] nums, int[] count, int lo, int hi) {
        if (lo >= hi - 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeCount(nums, count, lo, mid);
        mergeCount(nums, count, mid, hi);
        for (int i = lo; i < mid; i++) {
            for (int j = mid; j < hi; j++) {
                if (nums[i] > nums[j]) count[i]++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 1};
        new Q315_test1().countSmaller(a);
    }
}
