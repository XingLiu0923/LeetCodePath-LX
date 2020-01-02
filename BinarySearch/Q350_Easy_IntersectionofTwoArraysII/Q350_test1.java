import java.util.HashMap;
import java.util.Vector;

public class Q350_test1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Vector<Integer> result = new Vector<>();
        for (int i = 0; i < n1; i++) {
            if (!hashMap.containsKey(nums1[i])) {
                hashMap.put(nums1[i], 1);
            } else {
                hashMap.put(nums1[i], hashMap.get(nums1[i]) + 1);
            }
        }
        for (int i = 0; i < n2; i++) {
             if (hashMap.containsKey(nums2[i]) && hashMap.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                hashMap.put(nums2[i], hashMap.get(nums2[i]) - 1);
            }
        }
        if (result.size() == 0) return null;
        int[] a = new int[result.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = result.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {4, 9, 5};
        int[] b = {9,4,9,8,4};
        new Q350_test1().intersect(a, b);
    }
}
