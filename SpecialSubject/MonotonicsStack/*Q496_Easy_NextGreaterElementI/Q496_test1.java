import java.util.HashMap;
import java.util.Stack;

public class Q496_test1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) stack.pop();
            if (stack.isEmpty()) hashMap.put(nums2[i], -1);
            else hashMap.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = hashMap.get(nums1[i]);
        return res;
    }
}
