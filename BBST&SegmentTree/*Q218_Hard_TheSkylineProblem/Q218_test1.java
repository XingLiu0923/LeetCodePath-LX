import java.util.*;

public class Q218_test1 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyLine = new ArrayList<>();
        int n = buildings.length;
        if (n == 0) return skyLine;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts.add(buildings[i][0]); ts.add(buildings[i][1]);
        }
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        int k = 0;
        for (int node : ts) {
            hm1.put(node, k); hm2.put(k, node);
            k++;
        }
        SegmentTree st = new SegmentTree(2 * n);
        for (int i = 0; i < n; i++) {
            st.update(hm1.get(buildings[i][0]), hm1.get(buildings[i][1]) - 1, buildings[i][2]);
        }

        int preHeight = 0;
        for (int i = 0; i <= k; i++) {
            int height = st.getHeight(i);
            if (height == preHeight) continue;
            List<Integer> line = new ArrayList<>();
            line.add(hm2.get(i)); line.add(height);
            skyLine.add(line);
            preHeight = height;
        }
        return skyLine;
    }

    private class SegmentTree {
        private class Node {
            private int data;
            private int left, right;

            Node(int begin, int end) {
                left = begin; right = end; data = 0;
            }
        }

        private Node[] st;

        protected SegmentTree(int n) {
            st = new Node[4 * n + 2];
            build(0, 0, n - 1);
        }

        private void build(int i, int begin, int end) {
            st[i] = new Node(begin, end);
            if (begin == end) return;
            int mid = begin + (end - begin)/2;
            build(2 * i + 1, begin, mid);
            build(2 * i + 2, mid + 1, end);
        }

        protected void update(int begin, int end, int height) {
            update(0, begin, end, height);
        }

        private void update(int i, int begin, int end, int height) {
            if (st[i].right < begin || st[i].left > end) return;
            if (st[i].left >= begin && st[i].right <= end) {
                st[i].data = Math.max(st[i].data, height);
                return;
            }
            pushdown(i);
            update(2 * i + 1, begin, end, height);
            update(2 * i + 2, begin, end, height);
        }

        protected int getHeight(int index) {
            return getHeight(0, index);
        }

        private int getHeight(int i, int index) {
            if (st[i].left == st[i].right) return st[i].data;
            pushdown(i);
            int mid = st[i].left + (st[i].right - st[i].left)/2;
            if (index <= mid) return getHeight(2 * i + 1, index);
            else return getHeight(2 * i + 2, index);
        }

        private void pushdown(int i) {
            if (st[i].left == st[i].right || st[i].data == 0) return;
            st[2 * i + 1].data = Math.max(st[2 * i + 1].data, st[i].data);
            st[2 * i + 2].data = Math.max(st[2 * i + 2].data, st[i].data);
            st[i].data = 0;
        }
    }



    public static void main(String[] args) {
        int[][] q = new int[5][3];
        q[0] = new int[] {2,9,10};
        q[1] = new int[] {3,7,15};
        q[2] = new int[] {5,12,12};
        q[3] = new int[] {15,20,10};
        q[4] = new int[] {19,24,8};
        new Q218_test1().getSkyline(q);
    }
}
