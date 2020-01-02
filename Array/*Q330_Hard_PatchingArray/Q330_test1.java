public class Q330_test1 {
    public int minPatches(int[] nums, int n) {
        long range = 1;
        int count = 0;
        int length = nums.length;
        int k = 0;
        while (range <= n) {
            if (k < length && nums[k] <= range) range += nums[k++];
            else {
                count++;
                range = 2 * range;
            }
        }
        return count;
    }
}