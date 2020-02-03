public class Q8_test1 {
    public int myAtoi(String str) {
        String subS = str.trim();
        int n = subS.length();
        if (n == 0 || !(isNumber(subS, 0) || isPosOrNeg(subS, 0))) return 0;
        int i = 0; boolean posi = subS.charAt(0) == '-' ? false : true;
        int base = 0;
        while (i < n) {
            if (i > 0 && (subS.charAt(i) < '0' || subS.charAt(i) > '9')) break;
            else if (isNumber(subS, i)){
                if (posi && (Integer.MAX_VALUE/10 < base || (Integer.MAX_VALUE/10 == base && subS.charAt(i) > '7'))) return Integer.MAX_VALUE;
                if (!posi && (Integer.MIN_VALUE/10 > -base || (Integer.MIN_VALUE/10 == -base && subS.charAt(i) > '8')))return Integer.MIN_VALUE;
                base = 10 * base + (subS.charAt(i) - '0');
            }
            i++;
        }
        if (posi) return base;
        return -base;
    }

    private boolean isNumber(String s, int i) {
        return s.charAt(i) >= '0' && s.charAt(i) <= '9';
    }

    private boolean isPosOrNeg(String s, int i) {
        return s.charAt(i) == '+' || s.charAt(i) == '-';
    }

    public static void main(String[] args) {
        new Q8_test1().myAtoi("-   42");
    }
}
