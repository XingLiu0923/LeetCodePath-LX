import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q18_test1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> lists4 = new ArrayList<>();
        Arrays.sort(nums);
        int i = n - 1;
        while (i > -1) {
            List<List<Integer>> lists3 = threeSum(nums, target - nums[i], i);
            for (List<Integer> list : lists3) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list); newList.add(nums[i]);
                lists4.add(newList);
            }
            i = fintTheLastDiff(nums, i, 0);
        }
        return lists4;
    }

    private List<List<Integer>> threeSum(int[] nums, int target, int hi) {
        int k = hi - 1;
        List<List<Integer>> lists3 = new ArrayList<>();
        while (k > -1) {
            int i = 0, j = k - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) i = findTheNextDiff(nums, i, j);
                else if (sum > target) j = fintTheLastDiff(nums, j, i);
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[j]); list.add(nums[k]);
                    lists3.add(list);
                    i = findTheNextDiff(nums, i, j); j = fintTheLastDiff(nums, j, i);
                }
            }
            k = fintTheLastDiff(nums, k, 0);
        }
        return lists3;
    }

    private int findTheNextDiff(int[] nums, int i, int hi_bond) {
        while (i < hi_bond && nums[i] == nums[i + 1]) i++;
        return i + 1;
    }

    private int fintTheLastDiff(int[] nums, int i, int lo_bond) {
        while (i > lo_bond && nums[i] == nums[i - 1]) i--;
        return i - 1;
    }
}
