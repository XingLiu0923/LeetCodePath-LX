public class Q214_test1 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        char[] chars = new char[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i % 2 == 0) chars[i] = '#';
            else chars[i] = s.charAt(i / 2);
        }
        int[] p = new int[2 * n + 1];
        int center = 0, maxRight = 0;
        int maxI = 0;
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i >= maxRight) {
                int r = getRadius(chars, i);
                center = i; maxRight = i + r; p[i] = r;
            } else {
                int i_mirror = 2 * center - i;
                if (i_mirror - p[i_mirror] != 2 * center - maxRight) p[i] = Math.min(p[i_mirror], maxRight - i);
                else {
                    int r = getRadius(chars, i);
                    center = i; maxRight = i + r; p[i] = r;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (i - p[i] == 0 && i > maxI) maxI = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2 * n - 1; i > -1; i = i - 2) {
            sb.append(chars[i]);
        }
        int begin = maxI + p[maxI] + 1;
        if (begin < 2 * n + 1 && chars[begin] == '#') begin++;
        for (int i = begin; i < 2 * n + 1; i = i + 2) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private int getRadius(char[] chars, int i) {
        int r = 0, n = chars.length;
        while (i - r > -1 && i + r < n && chars[i + r] == chars[i - r]) r++;
        return r - 1;
    }

    public static void main(String[] args) {
        new Q214_test1().shortestPalindrome("aaaaa");
    }
}
