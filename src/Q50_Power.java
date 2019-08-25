public class Q50_Power {
    public double myPow(double x, int n) {
        double base = x;
        double pow = 1;
        double k = n;
        while (n != 0) {
            if (n % 2 != 0) pow = base * pow;
            base = base * base;
            n = n/2;
        }
        if (k < 0) return 1.0/pow;
        return pow;
    }

    public static void main(String[] args) {
        Q50_Power power = new Q50_Power();
        double a = power.myPow(8.843, -5);
        System.out.println(a);
    }
}
