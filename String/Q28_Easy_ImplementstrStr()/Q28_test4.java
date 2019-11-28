public class Q28_test4 {

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) return 0;
        int[] shift = buildShift(needle);
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (haystack.charAt(i) == needle.charAt(j)) { i++; j++; }
            else {
                if (i - j + m >= n) return -1;
                i = i - j + shift[needle.charAt(i - j + m)];
                j = 0;
            }
        }
        haystack.indexOf(needle);
        if (i - j >= 0 && i - j <= n - m) return i - j;
        return -1;
    }

    private int[] buildShift(String p) {
        int N = 1005, m = p.length();
        int[] shift = new int[N];
        for (int i = 0; i < N; i++) {
            shift[i] = m + 1;
        }
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        return shift;
    }

    public static void main(String[] args) {
        new Q28_test4().strStr("mississippi", "sipp");
    }
}
