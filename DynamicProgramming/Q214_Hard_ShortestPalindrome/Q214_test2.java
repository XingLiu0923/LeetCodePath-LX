public class Q214_test2 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String newS = s + "#" + new StringBuilder(s).reverse().toString();
        int[] next = buildNext(newS);
        int p = next[2 * n];
        int res = n - 1 - p;
        String result = "";
        for (int i = 0; i < res; i++) {
            result += s.charAt(n - 1 - i);
        }
        return result + s;
    }

    private int[] buildNext(String newS) {
        int n = newS.length();
        int[] next = new int[n];
        int t = -1, j = 0;
        next[0] = -1;
        while (j < n - 1) {
            if (t == -1 || newS.charAt(t) == newS.charAt(j)) {
                next[++j] = ++t;
            } else {
                t = next[t];
            }
        }
        return next;
    }
}
