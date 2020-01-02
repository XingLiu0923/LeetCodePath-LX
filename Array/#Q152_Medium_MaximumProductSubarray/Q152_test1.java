public class Q152_test1 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int i = 0;
        int maxProduct = Integer.MIN_VALUE;
        while (i < n) {
            if (nums[i] == 0 && maxProduct < 0) maxProduct = 0;
            while (i < n && nums[i] == 0) i++;
            if (i == n) break;
            int j = i;
            while (j < n && nums[j] != 0) j++;
            int product = getMaxProduct(nums, i, j);
            if (product > maxProduct) maxProduct = product;
            i = j;
        }
        return maxProduct;
    }

    private int getMaxProduct(int[] nums, int lo, int hi) {
        int posMax = Integer.MIN_VALUE;
        int negMin = 1, negMax = 0;
        int preP = 1;
        for (int i = lo; i < hi; i++) {
            preP = preP * nums[i];
            if (preP > 0) posMax = preP;
            else {
                if (negMin > 0 && negMax < 0) negMin = negMax;
                negMax = preP;
            }
        }
        return Math.max(posMax, negMax/negMin);
    }
}
