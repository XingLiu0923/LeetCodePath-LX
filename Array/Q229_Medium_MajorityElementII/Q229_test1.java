import java.util.ArrayList;
import java.util.List;

public class Q229_test1 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int num1 = 0, num2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
            else {
                if (count1 > 0 && count2 > 0) { count1--; count2--; }
                else if (count1 <= 0) { num1 = nums[i]; count1 = 1; }
                else { num2 = nums[i]; count2 = 1; }
            }
        }
        count1 = 0; count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(num1);
        if (count2 > n / 3) result.add(num2);
        return result;
    }
}