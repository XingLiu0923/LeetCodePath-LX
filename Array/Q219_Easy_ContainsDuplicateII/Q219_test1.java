import java.util.HashMap;

public class Q219_test1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k < 1) return false;
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(nums[i])) hm.put(nums[i], i);
            else {
                if (i - hm.get(nums[i]) <= k) return true;
                else hm.replace(nums[i], i);
            }
        }
        return false;
    }
}
