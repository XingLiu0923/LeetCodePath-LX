public class Q233_test2 {
    public int countDigitOne(int n) {
        if (n < 0) return 0;
        String s = String.valueOf(n);
        int sLength = s.length();
        int count = 0;
        for (int i = 0; i < sLength; i++) {
            count += getCount(n, i, sLength);
        }
        return count;
    }

    private int getCount(int n, int i, int digitLenth) {
        int afterZero = (int) Math.pow(10, digitLenth - i - 1);
        int thisDigit = n / afterZero % 10;
        int numBefore = n / (10 * afterZero);
        int numAfter = n % afterZero;
        int count = 0;
        if (thisDigit > 1) count = (numBefore + 1) * afterZero;
        else if (thisDigit == 1) count = numBefore * afterZero + numAfter + 1;
        else count = (numBefore - 1) * afterZero + afterZero;
        return count;
    }

    public static void main(String[] args) {
        new Q233_test2().countDigitOne(1410065408);
    }
}
