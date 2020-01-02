import java.util.Stack;

public class Q166_1_test1 {
    public int subtractProductAndSum(int n) {
        Stack<Integer> s = new Stack();
        while (n > 0) {
            s.push(n % 10);
            n = n / 10;
        }
        int sum = 0, times = 1;
        while (!s.isEmpty()) {
            sum = sum + s.peek();
            times = times * s.peek();
            s.pop();
        }
        return times - sum;
    }
}
