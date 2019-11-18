public class Q275_test1 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = -1, hi = n - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo)/2;
            if (citations[mid] + mid > n) hi = mid - 1;
            else lo = mid;
        }
        if (hi > -1 && citations[hi] + hi == n) return n - hi;
        else return n - hi - 1;
    }
}
