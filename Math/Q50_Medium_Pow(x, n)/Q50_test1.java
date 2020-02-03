public class Q50_test1 {
    public double myPow(double x, int n) {
        double base = 1, sum = 1;
        while (n > 0) {
            if (base == 1) base *= x;
            else base = base * base;
            if (n % 2 == 1) sum *= base;
            n = n / 2;
        }
        return sum;
    }
}
