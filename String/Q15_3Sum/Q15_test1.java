import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15_test1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int i = n - 1;
        while (i > -1) {
            int j = 0, k = i - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) j = findNextDiff(nums, j);
                else if (sum > 0) k = findBeforeDiff(nums, k);
                else {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[j]); t.add(nums[k]); t.add(nums[i]);
                    list.add(t);
                    j = findNextDiff(nums, j);
                    k = findBeforeDiff(nums, k);
                }
            }
            i = findBeforeDiff(nums, i);
        }
        return list;
    }

    private int findNextDiff(int[] nums, int i) {
        int n = nums.length;
        while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        return i + 1;
    }

    private int findBeforeDiff(int[] nums, int i) {
        while (i > 0 && nums[i - 1] == nums[i]) i--;
        return i - 1;
    }
}
