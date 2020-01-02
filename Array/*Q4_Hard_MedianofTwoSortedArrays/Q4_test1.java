public class Q4_test1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int rank = (m + n)/2;
        if (m > n) {
            int[] t = nums1; nums1 = nums2; nums2 = t;
        }
        int t1 = findKthElement(nums1, nums2, rank);
        if ((m + n) % 2 == 1) return t1;
        int t2 = findKthElement(nums1, nums2, rank - 1);
        return (t1 + t2)/2.0;
    }

    private int findKthElement(int[] nums1, int[] nums2, int k) {       // 假设nums1个数小于等于nums2；
        int m = nums1.length, n = nums2.length;
        int lo = 0, hi = Math.min(m, k + 1);
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            int j = k - mid;
            if (j - 1 >= 0 && nums2[j - 1] > nums1[mid]) lo = mid + 1;
            else hi = mid;
        }
        if (lo < 0 || lo > m - 1) return nums2[k - lo];
        if (k - lo < 0 || k - lo > n - 1) return nums1[lo];
        return Math.min(nums1[lo], nums2[k - lo]);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        new Q4_test1().findMedianSortedArrays(nums1, nums2);
    }
}
