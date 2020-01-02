public class Q81_test1 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int mark = nums[0];
        if (target < mark) return searchInRightHalf(nums, target, mark, 0, n);
        if (target > mark) return searchInLeftHalf(nums, target, mark, 0, n);
        else return true;
    }

    // target小于mark
    private boolean searchInRightHalf(int[] nums, int target, int mark, int lo, int hi) {
        if (lo >= hi) {
            if (lo > nums.length - 1 || lo < 0) return false;
            else return nums[lo] == target;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > mark || nums[mid] < target) return searchInRightHalf(nums, target, mark, mid + 1, hi);
        else if (nums[mid] == mark) return searchInRightHalf(nums, target, mark, lo, mid) || searchInRightHalf(nums, target, mark, mid + 1, hi);
        else return searchInRightHalf(nums, target, mark, lo, mid);
    }

    // target大于mark
    private boolean searchInLeftHalf(int[] nums, int target, int mark, int lo, int hi) {
        if (lo >= hi) {
            if (lo > nums.length - 1 || lo < 0) return false;
            else return nums[lo] == target;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < mark || nums[mid] >= target) return searchInLeftHalf(nums, target, mark, lo, mid);
        else if (nums[mid] == mark) return searchInLeftHalf(nums, target, mark, lo, mid) || searchInLeftHalf(nums, target, mark, mid + 1, hi);
        else return searchInLeftHalf(nums, target, mark, mid + 1, hi);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 1};
        new Q81_test1().search(a, 3);
    }
}
