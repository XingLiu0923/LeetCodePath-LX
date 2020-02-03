import java.util.ArrayList;
import java.util.List;

public class Q163_test1 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<String> lostRanges = new ArrayList<>();
        if (n == 0) {
            if (lower != upper) lostRanges.add(lower + "->" + upper);
            else lostRanges.add(Integer.toString(lower));
            return lostRanges;
        }
        if (lower < nums[0]) {
            if (lower + 1 < nums[0]) lostRanges.add(lower + "->" + (nums[0] - 1));
            else lostRanges.add(Integer.toString(lower));
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i - 1] < nums[i] - 1) {
                if (nums[i - 1] < nums[i] - 2) lostRanges.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
                else lostRanges.add(Integer.toString(nums[i - 1] + 1));
            }
        }
        if (nums[n - 1] < upper) {
            if (nums[n - 1] < upper - 1) lostRanges.add((nums[n - 1] + 1) + "->" + upper);
            else lostRanges.add(Integer.toString(upper));
        }
        return lostRanges;
    }

    public static void main(String[] args) {
        System.out.println(128 & 192);
    }
}
