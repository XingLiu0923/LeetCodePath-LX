public class Q556_test1 {
    public int nextGreaterElement(int n) {
        char[] nchar = String.valueOf(n).toCharArray();
        int cLength = nchar.length;
        int desPos = cLength - 2;
        while (desPos > -1 && nchar[desPos] >= nchar[desPos + 1]) desPos--;
        if (desPos < 0) return -1;
        int nextMore = findNextNoMore(nchar, desPos + 1, cLength, nchar[desPos]) - 1;
        swap(nchar, desPos, nextMore);
        reverse(nchar, desPos + 1, cLength - 1);
        String ns = String.valueOf(nchar);
        int base = Integer.valueOf(ns.substring(0, cLength - 1));
        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && ns.charAt(cLength - 1) > '7')) return -1;
        return Integer.valueOf(ns);
    }

    private int findNextNoMore(char[] chars, int lo, int hi, char target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (chars[mid] > target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) swap(chars, i++, j--);
    }

    public static void main(String[] args) {
        new Q556_test1().nextGreaterElement(13);
    }
}
