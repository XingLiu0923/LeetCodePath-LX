
import java.util.HashMap;
import java.util.TreeSet;

public class Q253_test1 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        // 离散化原数组；
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(intervals[i][0]); treeSet.add(intervals[i][1]);
        }
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        int k = 0;
        for (int each : treeSet) {
            hm1.put(each, k);
            k++;
        }
        // 离散化后的值插入线段树；
        SegmentTree st = new SegmentTree(k);
        for (int i = 0; i < n; i++) {
            st.update(hm1.get(intervals[i][0]), hm1.get(intervals[i][1]) - 1);
        }
        int max = 0;
        // 逐个查询取最大；
        for (int i = 0; i < k; i++) {
            int sum = st.query(i);
            if (sum > max) max = sum;
        }
        return max;
    }

    private class SegmentTree {
        private class Node {
            int data;
            int left, right;

            Node(int left, int right) {
                this.left = left; this.right = right;
            }
        }

        private Node[] st;

        SegmentTree(int n) {
            st = new Node[4 * n + 2];
            build(0, 0, n - 1);
        }

        private void build(int i, int lo, int hi) {
            st[i] = new Node(lo, hi);
            if (lo == hi) return;
            int mid = lo + (hi - lo)/2;
            build(2 * i + 1, lo, mid);
            build(2 * i + 2, mid + 1, hi);
        }

        protected void update(int begin, int end) {
            update(0, begin, end);
        }

        private void update(int i, int begin, int end) {
            if (st[i].right < begin || st[i].left > end) return;
            if (st[i].left >= begin && st[i].right <= end) {
                st[i].data++;
                return;
            }
            pushdown(i);
            update(2 * i + 1, begin, end); update(2 * i + 2, begin, end);
        }

        public int query(int index) {
            return query(0, index);
        }

        private int query(int i, int index) {
            if (st[i].left == st[i].right) return st[i].data;
            pushdown(i);
            int mid = st[i].left + (st[i].right - st[i].left)/2;
            if (index <= mid) return query(2 * i + 1, index);
            else return query(2 * i + 2, index);
        }

        private void pushdown(int i) {
            if (st[i].data == 0 || st[i].left == st[i].right) return;
            st[2 * i + 1].data += st[i].data;
            st[2 * i + 2].data += st[i].data;
            st[i].data = 0;
        }
    }

}
