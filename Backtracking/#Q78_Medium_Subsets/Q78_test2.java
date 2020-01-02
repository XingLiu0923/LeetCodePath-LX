import java.util.ArrayList;
import java.util.List;

public class Q78_test2 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int setsNum = 1 << n;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < setsNum; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) subset.add(nums[j]);
            }
            subsets.add(subset);
        }
        return subsets;
    }
}

/*https://leetcode-cn.com/problems/subsets/solution/wei-yun-suan-by-yi-qu-xin-ci/*/