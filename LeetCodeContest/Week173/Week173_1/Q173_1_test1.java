public class Q173_1_test1 {
    public int removePalindromeSub(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int i = 0, j = n - 1;
        while (j > i) {
            if (s.charAt(j) != s.charAt(i)) return 2;
            i++; j--;
        }
        return 1;
    }
}
