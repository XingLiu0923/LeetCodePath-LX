public class Q306_test1 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3) return false;
        for (int i = 0; i < n; i++) {
            if (num.charAt(0) == '0' && i > 0) break;
            for (int j = i + 1; j < n; j++) {
                if (num.charAt(i + 1) == '0' && j > i + 1) break;
                String firstNum = num.substring(0, i + 1);
                String seconNum = num.substring(i + 1, j + 1);
                if (isAdditiveNumber(firstNum, seconNum, num)) return true;
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String a, String b, String num) {
        int begin = a.length() + b.length();
        int n = num.length();
        if (begin >= n) return false;
        while (begin < n) {
            String sum = add(a, b);
            int end = begin + sum.length();
            if (end > n || !num.substring(begin, end).equals(sum)) return false;
            begin = end;
            a = b; b = sum;
        }
        return true;
    }

    private String add(String a, String b) {
        boolean mark = false;
        StringBuilder sb = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int n = Math.max(a.length(), b.length());
        for (int i = 0; i < n; i++) {
            int res = 0;
            if (i < a.length()) res += (a.charAt(i) - '0');
            if (i < b.length()) res += (b.charAt(i) - '0');
            if (mark) { res += 1; mark = false; }
            sb.append(res % 10);
            if (res >= 10) mark = true;
        }
        if (mark) sb.append("1");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new Q306_test1().isAdditiveNumber("101");
    }
}
