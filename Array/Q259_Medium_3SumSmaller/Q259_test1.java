import java.util.Arrays;

public class Q259_test1 {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int k = n - 1; k > -1; k--) {
            for (int right = k - 1; right > -1; right--) {
                int left = 0;
                while (left < right && nums[left] + nums[right] + nums[k] < target) {
                    left++; count++;
                }
            }
        }
        return count;
    }
}
