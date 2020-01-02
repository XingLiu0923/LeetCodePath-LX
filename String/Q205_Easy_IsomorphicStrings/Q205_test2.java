public class Q205_test2 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n == 0) return true;
        for (int i = 0; i < n; i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) return false;
        }
        return true;
    }
}
