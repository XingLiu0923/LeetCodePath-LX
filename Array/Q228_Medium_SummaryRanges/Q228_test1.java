import java.util.ArrayList;
import java.util.List;

public class Q228_test1 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int i = 0;
        List<String> ranges = new ArrayList<>();
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] == nums[j - 1] + 1) j++;
            if (j == i + 1) ranges.add(Integer.toString(nums[i]));
            else ranges.add(nums[i] + "->" + nums[j - 1]);
            i = j;
        }
        return ranges;
    }
}
