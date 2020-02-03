public class Q233_test1 {
    public int countDigitOne(int n) {
        if (n < 0) return 0;
        String s = String.valueOf(n);
        int sLength = s.length();
        int count = 0;
        for (int i = 0; i < sLength; i++) {
            count += getCount(s, i, sLength);
        }
        return count;
    }

    private int getCount(String s, int i, int n) {
        char c = s.charAt(i);
        String sBefore = i == 0 ? "0" : s.substring(0, i);
        String sNext = i == n - 1 ? "0" : s.substring(i + 1, n);
        int nBefore = Integer.valueOf(sBefore), nNext = Integer.valueOf(sNext);
        int count = 0;
        if (c > '1') count = nBefore * (int) Math.pow(10, n - 1 - i) + (int) Math.pow(10, n - i - 1);
        else if (c == '1') count = nBefore * (int) Math.pow(10, n - 1 - i) + nNext + 1;
        else count = (nBefore - 1) * (int) Math.pow(10, n - 1 - i) + (int) Math.pow(10, n - i - 1);
        return count;
    }

    public static void main(String[] args) {
        new Q233_test1().countDigitOne(13);
    }
}
