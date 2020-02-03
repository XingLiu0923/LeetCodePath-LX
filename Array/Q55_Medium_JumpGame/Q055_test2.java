public class Q055_test2 {
    enum status { GOOD, BAD, UNKONW }

    private status[] memo;

    public boolean canJump(int[] nums) {
        int n = nums.length;
        memo = new status[n];
        for (int i = 0; i < n; i++) {
            memo[i] = status.UNKONW;
        }
        memo[n - 1] = status.GOOD;
        return canJumpFromPoint(0, nums);
    }

    private boolean canJumpFromPoint(int i, int[] nums) {
        if (memo[i] != status.UNKONW) {
            return memo[i] == status.BAD ? false : true;
        }
        int farestP = Math.min(i + nums[i], nums.length - 1);
        for (int pos = i + 1; pos <= farestP; pos++) {
            if (canJumpFromPoint(pos, nums)) {
                memo[i] = status.GOOD;
                return true;
            }
        }
        memo[i] = status.BAD;
        return false;
    }
}
