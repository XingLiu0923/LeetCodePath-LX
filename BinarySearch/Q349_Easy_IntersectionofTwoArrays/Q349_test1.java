import java.util.HashMap;
import java.util.Vector;

public class Q349_test1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        int n1 = nums1.length, n2 = nums2.length;
        Vector<Integer> result = new Vector<>();
        for (int i = 0; i < n1; i++) {
            if (!hashMap.containsKey(nums1[i])) hashMap.put(nums1[i], true);
        }
        for (int i = 0; i < n2; i++) {
            if (hashMap.containsKey(nums2[i])) {
                if (hashMap.get(nums2[i])) {
                    result.add(nums2[i]);
                    hashMap.put(nums2[i], false);
                }
            }
        }
        int[] a = new int[result.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = result.get(i);
        }
        return a;
    }
}
