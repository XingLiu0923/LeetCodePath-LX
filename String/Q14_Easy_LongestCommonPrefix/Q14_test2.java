public class Q14_test2 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        String s = strs[0];
        for (int i = 1; i < n; i++) {
            s = Prefix(s, strs[i]);
            if (s == "") break;
        }
        return s;
    }

    private String Prefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) break;
            sb.append(s1.charAt(i++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = new String[3];
        s[0] = "flower";
        s[1] = "flow";
        s[2] = "flight";
        new Q14_test2().longestCommonPrefix(s);
    }
}
