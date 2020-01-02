import java.util.Stack;

public class Q42_test1 {
    public int trap(int[] height) {
            int n = height.length;
            int rainSum = 0;
        Stack<Integer> s = new Stack<>();       // s存储的是各个bottom；
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && height[s.peek()] < height[i]) {
                int bottom = s.pop();
                if (!s.isEmpty() && height[s.peek()] > height[bottom]) {
                    rainSum += ((Math.min(height[s.peek()], height[i]) - height[bottom]) * (i - s.peek() - 1));
                }
            }
            s.push(i);
        }
        return rainSum;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 0, 3, 2, 5};
        new Q42_test1().trap(a);
    }
}
