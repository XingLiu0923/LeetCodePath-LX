public class Q1137_test1 {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        while (n-- > 0) {
            int t = b;
            c = a + b + c;
            b = c - a - b;
            a = c - t - b;
        }
        return a;
    }

    public static void main(String[] args) {
        new Q1137_test1().tribonacci(4);
    }
}
