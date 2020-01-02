public class Q161_test1 {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length(), nt = t.length();
        if (ns - nt < -1 || ns - nt > 1) return false;
        if (ns - nt == 1 || ns - nt == -1) return isInsertOrDelete(s, t);
        return isReplace(s,t);
    }

    private boolean isInsertOrDelete(String s, String t) {
        int ns = s.length(), nt = t.length();
        int i = ns - 1, j = nt - 1;
        while (i > -1 && j > -1) {
            if (s.charAt(i) == t.charAt(j)) { i--; j--; }
            else break;
        }
        if (i == -1 || j == -1) return true;
        if (i > j) i--; else j--;
        return s.substring(0, i + 1).equals(t.substring(0, j + 1));
    }

    private boolean isReplace(String s, String t) {
        int ns = s.length(), nt = t.length();
        int i = ns - 1, j = nt - 1;
        while (i > -1 && j > -1) {
            if (s.charAt(i) == t.charAt(j)) { i--; j--; }
            else break;
        }
        if (i == -1) return false;
        return s.substring(0, i).equals(t.substring(0, j));
    }
}
