public class Q274_test1_improve {
    public int hIndex(int[] citations) {
        int lo = -1, hi = citations.length - 1;
        while (lo < hi) {
            int mi = partition(citations, lo + 1, hi + 1);
            if (mi + 1 > citations[mi]) hi = mi - 1;
            else lo = mi;
        }
        return hi + 1;
    }

    public static int partition(int[] citation, int lo, int hi) {      // [lo, hi)
        int mi = lo; int T_pivot = citation[lo];
        for (int k = lo + 1; k < hi; k++) {
            if (citation[k] > T_pivot) swap(citation, k, ++mi);
        }
        swap(citation, lo, mi);
        return mi;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
