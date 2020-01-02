public class Q136_test1 {
    public int singleNumber(int[] nums) {
        int t = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            t ^= nums[i];
        }
        return t;
    }
}
