import java.util.ArrayList;
import java.util.List;

public class Q46_test2 {
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
                tmp.add(nums[hi - 1]);
                swap(tmp, i, hi - 1);
                permutationList.add(tmp);
            }
        }
        return permutationList;
    }

    private void swap(List<Integer> list, int i, int j) {
        if (i == j) return;
        list.set(i, list.get(i) + list.get(j));
        list.set(j, list.get(i) - list.get(j));
        list.set(i, list.get(i) - list.get(j));
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        new Q46_test2().permute(a);
    }
}
