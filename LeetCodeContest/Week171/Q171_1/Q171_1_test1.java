public class Q171_1_test1 {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for (int i = 1; i < n; i++) {
            if (!haveZero(i) && !haveZero(n - i)) {
                res[0] = i; res[1] = n - i;
                return res;
            }
        }
        return res;
    }

    private boolean haveZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) return true;
            n /= 10;
        }
        return false;
    }
}
