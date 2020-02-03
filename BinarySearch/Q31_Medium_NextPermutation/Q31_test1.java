public class Q31_test1 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int next = findTheNextMoreThan(nums, i, n, nums[i - 1]);
                swap(nums, i - 1, next);
                reverse(nums, i, n - 1);
                return;
            }
        }
        reverse(nums, 0, n - 1);
    }

    private int findTheNextMoreThan(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > target) lo = mid + 1;
            else hi = mid;
        }
        return lo - 1;
    }

    private void reverse(int[] nums, int i, int j) {
        if (i >= j) return;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[] {5, 4, 7, 5, 3, 2};
        new Q31_test1().nextPermutation(a);
    }
}
