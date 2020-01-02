public class Q278_test1 extends VersionControl {

    public int firstBadVersion(int n) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid - 1;
            else lo = mid;
        }
        return hi + 1;
    }
}
