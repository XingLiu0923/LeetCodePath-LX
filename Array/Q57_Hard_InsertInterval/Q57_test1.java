import java.util.Vector;

public class Q57_test1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int beginP = findBeginPosition(intervals, newInterval[0]), endP = findEndPosition(intervals, newInterval[1]);
        int newBegin = newInterval[0], newEnd = newInterval[1];
        if (beginP - 1 > -1 && beginP - 1 < n && intervals[beginP - 1][1] >= newBegin) { newBegin = intervals[beginP - 1][0]; }
        if (endP - 1 > -1 && endP - 1 < n && intervals[endP - 1][1] >= newEnd) { newEnd = intervals[endP - 1][1]; }
        else if (endP > -1 && endP < n && intervals[endP][0] == newEnd) newEnd = intervals[endP][1];
        Vector<int[]> newIntervals = new Vector<>();
        int i = 0;
        while (i < n && intervals[i][1] < newBegin) {
            newIntervals.add(intervals[i++]);
        }
        newIntervals.add(new int[] {newBegin, newEnd});
        while (i < n) {
            if (intervals[i][0] > newEnd) newIntervals.add(intervals[i]);
            i++;
        }
        int[][] newIs = new int[newIntervals.size()][2];
        for (int k = 0; k < newIs.length; k++) {
            newIs[k] = newIntervals.get(k);
        }
        return newIs;
    }

    private int findBeginPosition(int[][] intervals, int begin) {
        int lo = 0, hi = intervals.length;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (intervals[mid][0] < begin) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int findEndPosition(int[][] intervals, int end) {
        int lo = 0, hi = intervals.length;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (intervals[mid][0] < end) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{1, 3}, {6, 9}};
        int[] b = new int[] {2, 5};
        new Q57_test1().insert(a, b);
    }
}
