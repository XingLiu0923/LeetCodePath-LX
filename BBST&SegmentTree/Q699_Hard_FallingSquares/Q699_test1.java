import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Q699_test1 {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> heightList = new ArrayList<>();
        if (n == 0) return heightList;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(positions[i][0]); treeSet.add(positions[i][0] + positions[i][1] - 1);
        }
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        int k = 0;
        for (int each : treeSet) {
            hm1.put(each, k++);
        }
        SegmentTree st = new SegmentTree(k);
        for (int i = 0; i < n; i++) {
            int begin = hm1.get(positions[i][0]), end = hm1.get(positions[i][0] + positions[i][1] - 1);
            int max = st.query(begin, end);
            st.update(begin, end, max + positions[i][1]);
            heightList.add(st.query(0, k - 1));
        }
        return heightList;
    }

    private class SegmentTree {
        private class Node {
            private int data, mark;
            private int left, right;
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

        protected void update(int begin, int end, int val) {
            update(0, begin, end, val);
        }

        private int update(int i, int begin, int end, int val) {
            if (st[i].right < begin || st[i].left > end) return st[i].data;
            if (st[i].left >= begin && st[i].right <= end) {
                st[i].data = val; st[i].mark = val;
                return st[i].data;
            }
            pushdown(i);
            int leftMax = update(2 * i + 1, begin, end, val);
            int rightMax = update(2 * i + 2, begin, end, val);
            st[i].data = Math.max(leftMax, rightMax);
            return st[i].data;
        }

        protected int query(int begin, int end) {
            return query(0, begin, end);
        }

        private int query(int i, int begin, int end) {
            if (st[i].right < begin || st[i].left > end) return Integer.MIN_VALUE;
            if (st[i].left >= begin && st[i].right <= end) {
                return st[i].data;
            }
            pushdown(i);
            int leftMax = query(2 * i + 1, begin, end);
            int rightMax = query(2 * i + 2, begin, end);
            return Math.max(leftMax, rightMax);
        }

        private void pushdown(int i) {
            if (st[i].mark == 0 || st[i].left == st[i].right) return;
            st[2 * i + 1].data = st[2 * i + 1].mark = st[i].mark;
            st[2 * i + 2].data = st[2 * i + 2].mark = st[i].mark;
            st[i].mark = 0;
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{2, 5}, {2, 7}, {1, 10}, {1, 10}, {2, 6}};
        new Q699_test1().fallingSquares(a);
    }
}
