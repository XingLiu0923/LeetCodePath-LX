public class Q170_1_test1 {
    public String freqAlphabets(String s) {
        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            int num = 0;
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                num = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
                i = i + 3;
            } else {
                num = s.charAt(i) - '0';
                i = i + 1;
            }
            sb.append((char) ('a' + num + 1));
        }
        return sb.toString();
    }
}
