import java.util.HashMap;

public class Q128_test2 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], true);
        }
        for (int i = 0; i < n; i++) {
            if (hashMap.get(nums[i]) == false) continue;
            int count = 0, t1 = nums[i], t2 = nums[i] - 1;
            while (hashMap.containsKey(t1)) {
                hashMap.put(t1, false);
                count++;
                t1++;
            }
            while (hashMap.containsKey(t2)) {
                hashMap.put(t2, false);
                count++;
                t2--;
            }
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }
}
