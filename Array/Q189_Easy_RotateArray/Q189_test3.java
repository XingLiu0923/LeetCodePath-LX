public class Q189_test3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length; k = k % n;
        reverse(nums, 0, (n - k - 1));
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int t = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = t;
            lo++; hi--;
        }
    }

    public static void main(String[] args) {
        Q189_test3 test = new Q189_test3();
        int[] nums = { 1,2,3,4,5,6,7 };
        test.rotate(nums, 3);
        for (int each : nums) {
            System.out.println(each);
        }
    }
}
