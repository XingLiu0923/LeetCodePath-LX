public class Q91_test1 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int a = 1;
        int b = 1;
        if (s.charAt(0) == '0') return 0;
        for (int i = 1; i < n; i++) {
            int t = 0;
            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
            if (c1 == '0') {
                if (c2 == '0') return 0;
                t = b;
            } else if (c1 == '1') {
                if (c2 == '0') t = a;
                else t = a + b;
            } else if (c1 == '2') {
                if (c2 == '0') t = a;
                else if (c2 > '6') t = b;
                else t = a + b;
            } else {
                if (c2 == '0') return 0;
                else t = b;
            }
            a = b;
            b = t;
        }
        return b;
    }
}
