public class Q186_test1 {
    public void reverseWords(char[] s) {
        int n = s.length;
        if (n == 0) return;
        reverse(s, 0, n);
        int i = 0, j = 0;
        while (i < n) {
            for (j = i; j < n && s[j] != ' '; j++);
            reverse(s, i, j);
            i = j + 1;
        }
    }

    private void reverse(char[] s, int lo, int hi) {
        if (lo >= hi) return;
        for (int i = lo; i < lo + (hi - lo) / 2; i++) {
            char t = s[i];
            s[i] = s[lo + hi - 1 - i];
            s[lo + hi - 1 - i] = t;
        }
    }
}
