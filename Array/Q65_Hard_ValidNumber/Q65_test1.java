public class Q65_test1 {
    public boolean isNumber(String s) {
        s = s.trim();
        String[] ss = s.split("e");
        if (ss.length < 1 || ss.length > 2) return false;
        if (ss.length == 1) {
            if (ss[0].length() != s.length()) return false;
            return isFloat(ss[0]);
        }
        if (ss[0].length() + ss[1].length() < s.length() - 1) return false;
        return isFloat(ss[0]) && isInteger(ss[1]);
    }

    private boolean isFloat(String s) {
        int n = s.length();
        if (n == 0) return false;
        String[] ss = s.split("\\.");
        if (ss.length < 1 || ss.length > 2) return false;
        if (ss.length == 1) {
            if (ss[0].length() < s.length() - 1) return false;
            return isInteger(ss[0]);
        }
        if (ss[0].length() + ss[1].length() < s.length() - 1) return false;
        return (ss[0].isEmpty() || ss[0].equals("+") || ss[0].equals("-") || (isInteger(ss[0]))) && (isInteger(ss[1]) && ss[1].charAt(0) != '-' && ss[1].charAt(0) != '+');
    }

    private boolean isInteger(String s) {
        int n = s.length();
        if (n == 0) return false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i > 0) return false;
                if (n == 1) return false;
            } else if (c < '0' || c > '9') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] ss = "e2e".split("e");
        new Q65_test1().isNumber("-.3e6");
    }
}
