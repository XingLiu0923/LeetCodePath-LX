import java.util.Arrays;
import java.util.Hashtable;

public class Q168_2_test1 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Hashtable<Integer, Integer> hashtable = new Hashtable();
        for (int i = 0; i < n; i++) {
            if (!hashtable.containsKey(nums[i])) hashtable.put(nums[i], 1);
            else hashtable.put(nums[i], hashtable.get(nums[i]) + 1);
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (hashtable.get(nums[i]) > 0) {
                int t = k, j = nums[i];
                while (t-- > 0) {
                    if (!hashtable.containsKey(j)) return false;
                    int count = hashtable.get(j);
                    if (count == 0) return false;
                    hashtable.put(j, count - 1);
                    j++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 2, 2, 1, 1};
        new Q168_2_test1().isPossibleDivide(a, 3);
    }
}
