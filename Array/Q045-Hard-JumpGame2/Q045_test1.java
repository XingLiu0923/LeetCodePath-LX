public class Q045_test1 {
    // 动态规划；
    public int jump(int[] nums) {
        int n = nums.length;
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) mark[i] = -1;
        mark[n - 1] = 0;
        for (int i = n - 2; i > -1; i--) {
            int farestPoint = Math.min(nums[i] + i, n - 1);
            for (int p = i + 1; p <= farestPoint; p++) {
                if (mark[p] < 0) continue;
                if (mark[i] < 0 | mark[p] < mark[i]) mark[i] = mark[p] + 1;
            }
        }
        return mark[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println((new Q045_test1()).jump(nums));
    }
}
