public class Q324_test1 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 0) return;
        int mid = (n - 1)/2;
        findThekth(nums, mid);
        int t = nums[mid];
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (nums[j] < t) swap(nums, i++, j++);
            else if (nums[j] > t) swap(nums, j, k--);
            else j++;
        }
        reverse(nums, 0, mid + 1);
        reverse(nums, mid + 1, n);
        int[] wiggle = new int[n];
        i = 0; j = mid + 1;
        for (int count = 0; count < n; count++) {
            if (count % 2 == 0) wiggle[count] = nums[i++];
            else wiggle[count] = nums[j++];
        }
        nums = wiggle;
    }

    private void findThekth(int[] nums, int k) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (mid < k) lo = mid + 1;
            else hi = mid;
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        for (int j = lo + 1; j < hi; j++) {
            if (nums[j] <= nums[lo]) swap(nums, ++i, j);
        }
        swap(nums, i, lo);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, --hi);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,5,1,1,6,4};
        new Q324_test1().wiggleSort(a);
    }
}
