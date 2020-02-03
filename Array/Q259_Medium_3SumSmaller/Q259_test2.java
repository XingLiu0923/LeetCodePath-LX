import java.util.Arrays;

public class Q259_test2 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int k = n - 1; k > -1; k--) {
            count += towSumLess(nums, 0, k - 1, target - nums[k]);
        }
        return count;
    }

    private int towSumLess(int[] nums, int lo, int hi, int target) {
        int count = 0;
        while (lo < hi) {
            while (lo < hi && nums[lo] + nums[hi] < target) lo++;
            count += lo;
            hi--;
        }
        count += ((hi + 1) * hi / 2);
        return count;
    }

    public static void main(String[] args) {
        new Q259_test2().threeSumSmaller(new int[] {-1, 1, -1, -1}, -1);
    }
}
