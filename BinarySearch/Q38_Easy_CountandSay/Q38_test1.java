public class Q38_test1 {
    public String countAndSay(int n) {
        String s = "1";
        while (--n > 0) {
            s = nextCont(s);
        }
        return s;
    }

    private String nextCont(String s) {
        int n = s.length();
        int i = 0;
        String result = "";
        while (i < n) {
            int count = 1;
            char c = s.charAt(i);
            while (i < n - 1 && s.charAt(i + 1) == c) { i++; count++; }
            result += (Integer.toString(count) + c);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        new Q38_test1().countAndSay(4);
    }
}
