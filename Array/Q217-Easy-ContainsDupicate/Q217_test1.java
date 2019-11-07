public class Q217_test1 {
    public boolean containsDuplicate(int[] nums) {
        mergeSort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    private static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    private static void mergeSort(int[] a, int lo, int hi) {    // [lo, hi)
        if (hi - lo <= 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int n = hi - lo; int[] cmp = new int[n];
        int i = lo, j = mid;
        for (int count = 0; count < hi - lo; count++) {
            if (i >= mid) cmp[count] = a[j++];
            else if (j >= hi) cmp[count] = a[i++];
            else if (a[i] < a[j]) cmp[count] = a[i++];
            else cmp[count] = a[j++];
        }
        for (int k = 0; k < hi - lo; k++) {
            a[lo + k] = cmp[k];
        }
    }

    public static void main(String[] args) {
        int[] num = {3, 3};
        System.out.println((new Q217_test1()).containsDuplicate(num));
    }
}
