import java.util.Stack;

public class Q739_test1 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            if (stack.isEmpty()) res[i] = 0;
            else res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new Q739_test1().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}