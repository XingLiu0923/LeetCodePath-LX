import java.util.Arrays;

public class Q493_test3 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        int[] C = new int[n + 1];
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += query(C, rank(copy, 2L * nums[i] + 1), n);
            update(C, rank(copy, nums[i]), 1);
        }
        return s;
    }

    private int rank(int[] copy, long k) {
        int lo = 0, hi = copy.length;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if ((long) copy[mid] < k) lo = mid + 1;
            else hi = mid;
        }
        return lo + 1;
    }

    private int query(int[] C, int x, int n) {
        int r = 0;
        for (int i = x; i <= n; i += lowbit(i)) {
            r += C[i];
        }
        return r;
    }

    private void update(int[] C, int x, int y) {
        for (int i = x; i > 0; i -= lowbit(i)) {
            C[i] += y;
        }
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,3,1};
        new Q493_test3().reversePairs(a);
    }
}
