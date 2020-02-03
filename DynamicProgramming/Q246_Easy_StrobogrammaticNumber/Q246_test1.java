public class Q246_test1 {
    public boolean isStrobogrammatic(String num) {
        char[] cs = num.toCharArray();
        int n = cs.length;
        int i = 0, j = n - 1;
        while (i <= j && i < n && j > -1) {
            if (!isBogrammatic(cs, i, j)) return false;
            i++; j--;
        }
        return true;
    }

    private boolean isBogrammatic(char[] cs, int i, int j) {
        if ((cs[i] == '8' && cs[j] == '8') || (cs[i] == '1' && cs[j] == '1') || (cs[i] == '0' && cs[j] == '0') || (cs[i] == '6' && cs[j] == '9') || (cs[i] == '9' && cs[j] == '6')) return true;
        return false;
    }
}
