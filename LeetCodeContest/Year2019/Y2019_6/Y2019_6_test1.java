public class Y2019_6_test1 {
    public int findNum(int n, int k) {
        int gcd = gcd(n, n - k);
        int nom = n / gcd, den = (n - k) / gcd;
        long base = 1;
        if (den == 1) base = (long) (n - k);
        for (int i = 0; i < n + 1; i++) {
            base = (long) (base * nom);
            if (base > 1000000007) base = base % 1000000007;
        }
        base = base - (n - k);
        if (base < 0) base += 1000000007;
        return (int) (base % 1000000007);
    }

    private int gcd(int a, int b) {
        int result = b == 0 ? a : gcd(b, a % b);
        return result;
    }

    public static void main(String[] args) {
        new Y2019_6_test1().findNum(4, 2);
    }
}
