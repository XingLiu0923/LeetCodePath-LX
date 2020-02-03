public class Q201_test1 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int res = m;
        for (int i = m; i <= n - 1; i++) {
            res &= i;
            if (res == 0) return 0;
        }
        return res & n;
    }

    public static void main(String[] args) {
        new Q201_test1().rangeBitwiseAnd(2147483646,2147483647);
    }
}
