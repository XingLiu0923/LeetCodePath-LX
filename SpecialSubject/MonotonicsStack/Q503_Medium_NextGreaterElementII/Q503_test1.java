import java.util.Stack;

public class Q503_test1 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[]{};
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }
        int[] res = new int[n]; res[maxPos] = -1;
        Stack<Integer> stack = new Stack<>(); stack.push(maxPos);
        for (int i = (maxPos - 1 + n) % n; i != maxPos; i = (i - 1 + n) % n) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) stack.pop();
            if (stack.isEmpty()) res[i] = -1;
            else res[i] = nums[stack.peek()];
            stack.push(i);
        }
        return res;
    }
}
