import java.util.ArrayList;
import java.util.List;

public class Q90_test1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetList.add(subset);
        int n = nums.length;
        QuickSort(nums, 0, n);
        int i = 0, j = 0;
        while (j < n) {
            while (j < n - 1 && nums[j] == nums[j + 1]) j++;
            List<List<Integer>> newList = new ArrayList<>(subsetList);
            for (List<Integer> each : subsetList) {
                List<Integer> tmp = new ArrayList<>(each);
                for (int k = 0; k < j - i + 1; k++) {
                    tmp.add(nums[j]);
                    newList.add(new ArrayList<>(tmp));
                }
            }
            j++; i = j;
            subsetList = newList;
        }
        return subsetList;
    }

    private void QuickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int partition = partition(nums, lo, hi);
        QuickSort(nums, lo, partition);
        QuickSort(nums, partition + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        for (int j = lo + 1; j < hi; j++) {
            if (nums[j] < nums[lo]) swap(nums, ++i, j);
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
        int[] a = {2, 2, 1};
        new Q90_test1().subsetsWithDup(a);
    }
}
