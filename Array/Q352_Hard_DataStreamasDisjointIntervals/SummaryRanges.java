import java.util.TreeSet;
import java.util.Vector;

class SummaryRanges {

    TreeSet<Integer> treeSet;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        treeSet = new TreeSet<>();
    }

    public void addNum(int val) {
        treeSet.add(val);
    }

    public int[][] getIntervals() {
        Vector<int[]> intervals = new Vector<>();
        for (int k : treeSet) {
            if (intervals.isEmpty() || intervals.lastElement()[1] < k - 1) {
                intervals.add(new int[] {k, k});
            } else {
                intervals.lastElement()[1] = k;
            }
        }
        int n = intervals.size();
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            result[i] = intervals.get(i);
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */