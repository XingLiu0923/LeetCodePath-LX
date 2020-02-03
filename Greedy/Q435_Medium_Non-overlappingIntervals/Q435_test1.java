import java.util.Arrays;

public class Q435_test1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length; if (n == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> (o1[1] - o2[1]));
        int ends = intervals[0][1], count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < ends) count++;
            else ends = intervals[i][1];
        }
        return count;
    }
}