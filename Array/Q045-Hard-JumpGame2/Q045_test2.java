public class Q045_test2 {
    // 贪心算法；
    public int jump(int[] nums) {
        int count = 0;      // 步数；
        int point = 0;      // 当前点，不断更新；
        int n = nums.length;
        while (point < n - 1) {
            count++;
            if (nums[point] + point >= n - 1) break;
            int pointRange = Math.min(n - 1, nums[point] + point);
            int maxDistance = 0;
            for (int nextPoint = point + 1; nextPoint <= pointRange; nextPoint++) {
                if (nums[nextPoint] + nextPoint > maxDistance) {
                    point = nextPoint; maxDistance = nums[nextPoint] + nextPoint;
                }
            }
        }
        return count;
    }
}
