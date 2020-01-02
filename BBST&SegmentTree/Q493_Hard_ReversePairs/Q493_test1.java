public class Q493_test1 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return reversePairs(nums, 0, n);
    }

    private int reversePairs(int[] nums, int lo, int hi) {
        if (lo >= hi - 1) return 0;
        int mid = lo + (hi - lo)/2;
        int left = reversePairs(nums, lo, mid);
        int right = reversePairs(nums, mid, hi);
        int fast = mid;
        int total = 0;
        for (int i = lo; i < mid; i++) {
            while (fast < hi) {
                long rightHalf = (long)nums[fast] * 2;
                if (rightHalf >= nums[i]) break;
                fast++;
            }
            total += (fast - mid);
        }
        merge(nums, lo, mid, hi);
        return left + right + total;
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo];
        int i = lo, j = mid;
        for (int count = 0; count < hi - lo; count++) {
            if (j >= hi) tmp[count] = nums[i++];
            else if (i >= mid) tmp[count] = nums[j++];
            else if (nums[j] < nums[i]) tmp[count] = nums[j++];
            else tmp[count] = nums[i++];
        }
        for (int count = 0; count < hi - lo; count++) {
            nums[lo + count] = tmp[count];
        }
    }
}
