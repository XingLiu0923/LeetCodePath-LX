import java.util.Stack;

public class Q84_test2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int n = heights.length;
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            while (s.peek() != -1 && heights[i] < heights[s.peek()]) {
                int index = s.pop();
                int width = i - 1 - s.peek();
                int area = width * heights[index];
                if (area > maxA) maxA = area;
            }
            s.push(i);
        }
        while (s.peek() != -1) {
            int index = s.pop();
            int width = n - 1 - s.peek();
            int area = width * heights[index];
            if (area > maxA) maxA = area;
        }
        return maxA;
    }
}
