public class Q14_test1 {
    public String longestCommonPrefix(String[] strs) {
        int i = 0, n = strs.length;
        if (n == 0) return "";
        int minLength = minLength(strs);
        if (minLength == 0) return "";
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (i >= minLength || !match(strs, i)) break;
            sb.append(strs[0].charAt(i++));
        }
        return sb.toString();
    }

    private int minLength(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() < minLength) minLength = strs[i].length();
        }
        return minLength;
    }

    private boolean match(String[] strs, int i) {
        char mark = strs[0].charAt(i);
        int n = strs.length;
        for (int j = 1; j < n; j++) {
            if (strs[j].charAt(i) != mark) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = new String[3];
        s[0] = "flower";
        s[1] = "flow";
        s[2] = "flight";
        new Q14_test1().longestCommonPrefix(s);
    }
}
