public class Q70_test1 {
    public int climbStairs(int n) {
        int a = 1; int b = 2;
        while (--n > 0) {
            b = a + b;
            a = b - a;
        }
        return a;
    }
}
