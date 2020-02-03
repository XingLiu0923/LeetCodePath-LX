
public class Q179_test1 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        quickSort(nums);
        StringBuilder sb = new StringBuilder();
        if (nums[0] == 0) return "0";
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void quickSort(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n);
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi - 1) return;
        int mid = partition(nums, lo, hi);
        quickSort(nums, lo, mid);
        quickSort(nums, mid + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        for (int j = lo + 1; j < hi; j++) {
            if (comparable(nums[j], nums[lo]) > 0) swap(nums, ++i, j);
        }
        swap(nums, i, lo);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int comparable(int i, int j) {
        String iS = String.valueOf(i), jS = String.valueOf(j);
        return comparable(iS + jS, jS + iS);
    }

    private int comparable(String iS, String jS) {
        int n = iS.length(), i = 0;
        while (i < n && iS.charAt(i) == jS.charAt(i)) i++;
        if (i == n) return 0;
        return iS.charAt(i) - jS.charAt(i);
    }
}
