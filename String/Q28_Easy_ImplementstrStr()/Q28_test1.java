public class Q28_test1 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(); int m = needle.length();
        int i = 0; int j = 0;
        while (i < n && j < m) {
            if (haystack.charAt(i) == needle.charAt(j)) { i++; j++; }
            else { i = i - j + 1; j = 0; }
        }
        if (i - j >= 0 && i - j <= n - m) return i - j;
        return -1;
    }

    public static void main(String[] args) {
        new Q28_test1().strStr("hello", "ll");
    }
}
