import java.util.ArrayList;
import java.util.List;

public class Q78_test1 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        return subsets(nums, n);
    }

    private List<List<Integer>> subsets(int[] nums, int hi) {
        List<List<Integer>> subsetsList = new ArrayList<>();
        if (hi <= 0) {
            subsetsList.add(new ArrayList<>());
            return subsetsList;
        }
        List<List<Integer>> lastSubsetsList = subsets(nums, hi - 1);
        for (List<Integer> each : lastSubsetsList) {
            subsetsList.add(new ArrayList<>(each));
            each.add(nums[hi - 1]);
            subsetsList.add(each);
        }
        return subsetsList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new Q78_test1().subsets(nums);
    }
}
