import java.util.Vector;

public class Q56_test1 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        quickSort(intervals, 0, n);
        Vector<int[]> newIntervals = new Vector<>();
        int i = 0;
        for (int j = 1; j <= n; j++) {
            if (j < n && intervals[j][0] <= intervals[i][1]) {
                intervals[i] = new int[] {intervals[i][0], Math.max(intervals[j][1], intervals[i][1])};
            } else {
                newIntervals.add(intervals[i]);
                i = j;
            }
        }
        int[][] newResult = new int[newIntervals.size()][2];
        for (int k = 0; k < newIntervals.size(); k++) {
            newResult[k] = newIntervals.get(k);
        }
        return newResult;
    }

    private void quickSort(int[][] intervals, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(intervals, lo, hi);
        quickSort(intervals, lo, p);
        quickSort(intervals, p + 1, hi);
    }

    private int partition(int[][] intervals, int lo, int hi) {
        int i = lo;
        for (int j = lo + 1; j < hi; j++) {
            if (intervals[j][0] < intervals[lo][0]) swap(intervals, ++i, j);
        }
        swap(intervals, lo, i);
        return i;
    }

    private void swap(int[][] intervals, int i, int j) {
        int[] t = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = t;
    }
}
