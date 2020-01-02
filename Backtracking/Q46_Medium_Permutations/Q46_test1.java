import java.util.ArrayList;
import java.util.List;

public class Q46_test1 {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        return permute(nums, n);
    }

    private List<List<Integer>> permute(int[] nums, int hi) {
        List<List<Integer>> permutationList = new ArrayList<>();
        if (hi == 1) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(nums[0]);
            permutationList.add(permutation);
            return permutationList;
        }
        for (List<Integer> each : permute(nums, hi - 1)) {
            for (int i = 0; i < hi; i++) {
                List<Integer> tmp = new ArrayList<>(each);
                if (i == hi - 1) tmp.add(nums[hi - 1]);
                else tmp.add(i, nums[i]);
                permutationList.add(tmp);
            }
        }
        return permutationList;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        new Q46_test1().permute(a);
    }
}
