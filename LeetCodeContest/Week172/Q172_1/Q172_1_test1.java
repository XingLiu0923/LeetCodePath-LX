public class Q172_1_test1 {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        char[] ss = s.toCharArray();
        int n = ss.length;
        for (int i = 0; i < n; i++) {
            if (ss[i] == '6') { ss[i] = '9'; break; }
        }
        return Integer.valueOf(String.valueOf(ss));
    }
}
