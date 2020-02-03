public class Q055_test1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int maxPos = n - 1;
        for (int i = n - 1; i > -1; i--) {
            if (nums[i] + i >= maxPos) maxPos = i;
        }
        if (maxPos > 0 || nums[maxPos] == 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println((new Q055_test1().canJump(nums)));
    }
}
