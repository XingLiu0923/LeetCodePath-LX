import java.util.ArrayList;
import java.util.List;

public class Q47_test1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        return permuteUnique(nums, n);
    }

    private List<List<Integer>> permuteUnique(int[] nums, int hi) {
        List<List<Integer>> permuteList = new ArrayList<>();
        if (hi == 1) {
            List<Integer> permute = new ArrayList<>();
            permute.add(nums[hi - 1]);
            permuteList.add(permute);
            return permuteList;
        }
        for (List<Integer> each : permuteUnique(nums, hi - 1)) {
            for (int i = hi - 1; i > -1; i--) {
                List<Integer> tmp = new ArrayList<>(each);
                if (i == hi - 1) tmp.add(nums[i]);
                else tmp.add(i, nums[hi - 1]);
                permuteList.add(tmp);
                if (i > 0 && nums[hi - 1] == tmp.get(i - 1)) break;
            }
        }
        return permuteList;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2 };
        new Q47_test1().permuteUnique(a);
    }
}
