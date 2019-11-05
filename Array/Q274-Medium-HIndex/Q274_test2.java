import com.sun.tools.classfile.ConstantPool;

public class Q274_test2 {
    public int hIndex(int[] citations) {
        mergeSort(citations);
        int count = 0;
        for (int i = 0; i < citations.length && citations[i] > i; i++) {
            count++;
        }
        return count;
    }

    public static void QuickSort(int[] citations) {
        QuickSort(citations, 0, citations.length);
    }

    private static void QuickSort(int[] citations, int lo, int hi) {    // [lo, hi)
        if (lo >= hi) return;
        int mi = partition(citations, lo, hi);
        QuickSort(citations, lo, mi);
        QuickSort(citations, mi + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int mi = lo; int T_pivot = a[lo];
        for (int k = lo + 1; k < hi; k++) {
            if (a[k] > T_pivot) swap(a, k, ++mi);
        }
        swap(a, mi, lo);
        return mi;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    private static void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi - 1) return;
        int mid = lo + (hi - lo)/2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int n = hi - lo; int[] comparable = new int[n];
        int i = lo; int j = mid;
        for (int count = 0; count < hi - lo; count++) {
            if (i >= mid) { comparable[count] = a[j++]; }
            else if (j >= hi) { comparable[count] = a[i++]; }
            else if (a[i] < a[j]) { comparable[count] = a[j++]; }
            else { comparable[count] = a[i++]; }
        }
        for (int k = 0; k < n; k++) {
            a[lo + k] = comparable[k];
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 0, 6, 1, 5};
        mergeSort(a);
    }
}
