import java.util.HashSet;

public class Q128_test3 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
        HashSet<Integer> hashSet = new HashSet<>();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!hashSet.contains(nums[i] - 1)) {
                int count = 0, t = nums[i];
                while (hashSet.contains(t)) {
                    count++; t++;
                }
                if (count > maxCount) maxCount = count;
            }
        }
        return maxCount;
    }
}
