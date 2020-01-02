public class Q238_test1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product_pre = new int[n + 1], product_after = new int[n + 1];
        product_pre[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            product_pre[i] = product_pre[i - 1] * nums[i - 1];
        }
        product_after[n] = 1;
        for (int i = n - 1; i > -1; i--) {
            product_after[i] = product_after[i + 1] * nums[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = product_pre[i] * product_after[i + 1];
        }
        return result;
    }
}
