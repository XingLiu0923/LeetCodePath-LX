public class Q5_test2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] chars = new char[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i % 2 == 0) chars[i] = '#';
            else chars[i] = s.charAt(i / 2);
        }
        int[] p = new int[2 * n + 1];
        int maxRight = 0, center = 0;
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i >= maxRight) {
                center = i; maxRight = i + getRadius(chars, i);
                p[i] = maxRight - i;
            } else {
                int i_mirror = 2 * center - i;
                if (i_mirror - p[i_mirror] != 2 * center - maxRight) {
                    p[i] = Math.min(p[i_mirror], maxRight - i);
                } else {
                    center = i; maxRight = i + getRadius(chars, i);
                    p[i] = maxRight - i;
                }
            }
        }
        int maxI = 0;
        for (int i = 0; i < 2 * n + 1; i++) {
            if (p[maxI] < p[i]) maxI = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxI - p[maxI]; i < maxI + p[maxI]; i++) {
            if (chars[i] != '#') sb.append(chars[i]);
        }
        return sb.toString();
    }

    private int getRadius(char[] chars, int i) {
        int r = 0, n = chars.length;
        while (i - r > -1 && i + r < n && chars[i - r] == chars[i + r]) r++;
        return r - 1;
    }

    public static void main(String[] args) {
        new Q5_test2().longestPalindrome("cbbd");
    }
}
