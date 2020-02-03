import java.util.Arrays;

public class Q16_test1 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Integer closest = null;
        Arrays.sort(nums);
        int k = n - 1;
        while (k > -1) {
            int i = 0, j = k - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (closest == null || Math.abs(sum - target) < Math.abs(closest.intValue() - target)) closest = sum;
                if (sum < target) i = findTheNextDiff(nums, i, j);
                else if (sum > target) j = findTheBeforeDiff(nums, j, i);
                else return sum;
            }
            k = findTheBeforeDiff(nums, k, 0);
        }
        return closest;
    }

    private int findTheNextDiff(int[] nums, int i, int uplimit) {
        while (i < uplimit && nums[i] == nums[i + 1]) i++;
        return i + 1;
    }

    private int findTheBeforeDiff(int[] nums, int i, int lowlimit) {
        while (i > lowlimit && nums[i] == nums[i - 1]) i--;
        return i - 1;
    }

    public static void main(String[] args) {
        int[] a = new int[] {-1, 2, 1, -4};
        new Q16_test1().threeSumClosest(a, 1);
    }
}
