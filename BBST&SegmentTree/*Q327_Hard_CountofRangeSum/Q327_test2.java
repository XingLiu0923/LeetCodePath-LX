public class Q327_test2 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return countRangeSum(sum, 0, n + 1, lower, upper);
    }

    private int countRangeSum(long[] sum, int lo, int hi, int lower, int upper) {
        if (lo >= hi - 1) return 0;
        int mid = lo + (hi - lo)/2;
        int left = countRangeSum(sum, lo, mid, lower, upper);
        int right = countRangeSum(sum, mid, hi, lower, upper);
        int slow = mid, fast = mid;
        int total = 0;
        for (int i = lo; i < mid; i++) {
            while (slow < hi && sum[slow] - sum[i] < lower) slow++;
            while (fast < hi && sum[fast] - sum[i] <= upper) fast++;
            total += fast - slow;
        }
        merge(sum, lo, mid, hi);
        return total + left + right;
    }

    private void merge(long[] sum, int lo, int mid, int hi) {
        long[] tmp = new long[hi - lo];
        int i = lo, j = mid;
        for (int k = 0; k < hi - lo; k++) {
            if (i >= mid) { tmp[k] = sum[j++]; }
            else if (j >= hi) { tmp[k] = sum[i++]; }
            else if (sum[j] < sum[i]) { tmp[k] = sum[j++]; }
            else tmp[k] = sum[i++];
        }
        for (int k = 0; k < hi - lo; k++) {
            sum[lo + k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] a = {-2, 5, -1};
        new Q327_test2().countRangeSum(a, -2, 2);
    }
}
