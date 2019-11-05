public class Q027_test1 {
    public static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0; int j = nums.length - 1;
        while (i <= j) {
            if (nums[j] == val) j--;
            else {
                if (nums[i] == val) {
                    swap(nums, i, j);
                }
                i++;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Q027_test1 test = new Q027_test1();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int length = test.removeElement(nums, val);
        System.out.println(length);
    }
}
