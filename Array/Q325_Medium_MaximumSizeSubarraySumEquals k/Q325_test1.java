import java.util.HashMap;

public class Q325_test1 {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        sums[0] = 0;
        HashMap<Integer, Integer> sumsToP = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            sumsToP.put(sums[i], i);
        }
        int maxGap = 0;
        for (int i = 0; i < n + 1; i++) {
            if (sumsToP.containsKey(sums[i] + k)) {
                int p = sumsToP.get(sums[i] + k);
                if (p - i > maxGap) maxGap = p - i;
            }
        }
        return maxGap;
    }
}
