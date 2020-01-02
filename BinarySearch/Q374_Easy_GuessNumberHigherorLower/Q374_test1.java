public class Q374_test1 extends GuessGame {
    public int guessNumber(int n) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (guess(mid) < 0) hi = mid - 1;
            else lo = mid;
        }
        return hi;
    }
}
