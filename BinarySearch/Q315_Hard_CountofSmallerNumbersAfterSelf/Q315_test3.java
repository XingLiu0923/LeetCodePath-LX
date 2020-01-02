import java.util.ArrayList;
import java.util.List;

public class Q315_test3 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> countList = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return countList;
        int[] count = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeCount(nums, index, count, 0, n);
        for (int i = 0; i < n; i++) {
            countList.add(count[i]);
        }
        return countList;
    }

    private void mergeCount(int[] nums, int[] index, int[] count, int lo, int hi) {
        if (lo >= hi - 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeCount(nums, index, count, lo, mid);
        mergeCount(nums, index, count, mid, hi);
        merge(nums, index, count, lo, mid, hi);
    }

    private void merge(int[] nums, int[] index, int[] count, int lo, int mid, int hi) {
        int[] tmpIndex = new int[hi - lo];
        int i = lo, j = mid;
        for (int mark = 0; mark < hi - lo; mark++) {
            if (i >= mid) { tmpIndex[mark] = index[j++]; }
            else if (j >= hi) { count[index[i]] += (mark + lo - i); tmpIndex[mark] = index[i++]; }
            else if (nums[index[j]] < nums[index[i]]) { tmpIndex[mark] = index[j++]; }
            else { count[index[i]] += (mark + lo - i); tmpIndex[mark] = index[i++]; }
        }
        for (int mark = 0; mark < hi - lo; mark++) {
            index[lo + mark] = tmpIndex[mark];
        }
    }
}
