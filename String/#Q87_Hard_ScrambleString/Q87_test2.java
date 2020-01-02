public class Q87_test2 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        if (n == 1) return s1.equals(s2);
        for (int i = 1; i < n; i++) {
            String s1Left = s1.substring(0, i), s1Right = s1.substring(i, n);
            String s2Left = s2.substring(0, i), s2Right = s2.substring(i, n);
            String s2ReverseLeft = s2.substring(n - i, n), s2ReverseRight = s2.substring(0, n - i);
            if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)||
            isScramble(s1Left, s2ReverseLeft) && isScramble(s1Right, s2ReverseRight)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q87_test2().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}
