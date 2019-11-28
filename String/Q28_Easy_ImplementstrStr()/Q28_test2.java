public class Q28_test2 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int i = 0; int j = 0;
        if (m == 0) return 0;
        int[] next = buildNext(needle);
        while (i < n && j < m) {
            if (j < 0 || haystack.charAt(i) == needle.charAt(j)) { i++; j++; }
            else j = next[j];
        }
        if (i - j >=0 && i - j <= n - m) return i - j;
        return -1;
    }

    private int[] buildNext(String p) {
        int m = p.length();
        int[] next = new int[m];
        int t = -1; int j = 0;
        next[j] = t;
        while (j < m - 1) {
            if (t < 0 || p.charAt(j) == p.charAt(t)) { j++; t++; next[j] = t; }
            else t = next[t];
        }
        return next;
    }
}
