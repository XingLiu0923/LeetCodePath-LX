public class Q10_test2 {
    public boolean isMatch(String s, String p) {
        int ns = s.length(), np = p.length();
        return isMatch(s, ns, p, np);
    }

    private boolean isMatch(String s, int ns, String p, int np) {       // ns, np是开区间；
        if (np == 0) return ns == 0;
        char c = p.charAt(np - 1);
        if (c >= 'a' && c <= 'z') return (ns > 0) && c == s.charAt(ns - 1) && isMatch(s, ns - 1, p, np - 1);
        if (c == '.') return ns > 0 && isMatch(s, ns - 1, p, np - 1);
        // c == '*'
        if (np < 2) return ns == 0;
        char cBefore = p.charAt(np - 2);
        if (cBefore >= 'a' && cBefore <= 'z') return (ns > 0 && cBefore == s.charAt(ns - 1) && isMatch(s, ns - 1, p, np)) || (isMatch(s, ns, p, np - 2));
        if (cBefore == '#') return isMatch(s, ns, p, np - 1);
        return isMatch(s, ns - 1, p, np) || isMatch(s, ns, p, np - 2);
    }
}
