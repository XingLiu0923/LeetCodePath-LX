public class Q274_test1 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int lo = -1, hi = n - 1;  // 找到citation[k] <= n - Rank(citation[k])的最大值；( , ]
        while (lo < hi) {
            int mi = partition(citations, lo + 1, hi + 1);
            if (citations[mi] > n - mi) hi = mi - 1;
            else lo = mi;
        }
        if (hi < 0 || n - hi > citations[hi]) return n - hi - 1;
        return n - hi;
    }

    // LGU写法；
    private static int partition(int[] a, int lo, int hi) {    // [lo, hi)
        int mi = lo; int T_pivot = a[lo];
        for (int k = lo + 1; k < hi; k++) {
            if (a[k] < T_pivot) swap(a, ++mi, k);
        }
        swap(a, lo, mi);
        return mi;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] citations = {4, 4, 0, 0};
        Q274_test1 test = new Q274_test1();
        test.hIndex(citations);
        for (int each: citations) {
            System.out.println(each);
        }
    }
}
