public class Q354_test1 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;
        mergeSort(envelopes, 0, n);     // 按照长度排序，然后就是求最长上升子数组；
        int[] dp = new int[n];
        int dpn = 0;
        for (int i = 0; i < n; i++) {
            int pos = binarySearch(dp, dpn, envelopes[i][1]);
            dp[pos] = envelopes[i][1];
            if (pos == dpn) dpn++;
        }
        return dpn;
    }

    private void mergeSort(int[][] envelopes, int lo, int hi) {
        if (lo >= hi - 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(envelopes, lo, mid);
        mergeSort(envelopes, mid, hi);
        merge(envelopes, lo, mid, hi);
    }

    private void merge(int[][] envelopes, int lo, int mid, int hi) {
        int i = lo, j = mid;
        int[][] tmp = new int[hi - lo][2];
        for (int count = 0; count < hi - lo; count++) {
            if (i >= mid)  tmp[count] = envelopes[j++];
            else if (j >= hi)  tmp[count] = envelopes[i++];
            else if (envelopes[i][0] < envelopes[j][0])  tmp[count] = envelopes[i++];
            else if (envelopes[i][0] > envelopes[j][0])  tmp[count] = envelopes[j++];
            else {
                if (envelopes[i][1] < envelopes[j][1]) tmp[count] = envelopes[j++];
                else tmp[count] = envelopes[i++];
            }
        }
        for (int count = 0; count < hi - lo; count++) {
            envelopes[lo + count] = tmp[count];
        }
    }

    private void swap(int[][] envelopes, int i, int j) {
        int[] t = envelopes[i];
        envelopes[i] = envelopes[j];
        envelopes[j] = t;
    }

    private int binarySearch(int[] dp, int dpn, int target) {
        int lo = 0, hi = dpn;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (dp[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
