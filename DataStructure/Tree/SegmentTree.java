public class SegmentTree {
    private class Node {
        int data;
        int begin, end;
        int mark;

        protected Node(int begin, int end) {
            this.data = 0;   this.begin = begin; this.end = end; this.mark = 0;
        }

        protected void addMard(int value) {
            mark += value;
        }

        protected void clear() {
            mark = 0;
        }
    }

    private Node[] tree;

    SegmentTree(int[] base) {
        int n = base.length;
        tree = new Node[n >> 1 + 1];
        build(base, 0, 0, n - 1);
    }

    private void build(int[] base, int i, int begin, int end) {
        tree[i] = new Node(begin, end);
        if (begin == end) {
            tree[i].data = base[begin];
            return;
        }
        int mid = begin + (end - begin)/2;
        build(base, 2 * i + 1, begin, mid);
        build(base, 2 * i + 2, mid + 1, end);
        tree[i].data = Math.min(tree[2 * i + 1].data, tree[2 * i + 2].data);
    }

    public int query(int begin, int end) {
        return query(0, begin, end);
    }

    private int query(int i, int begin, int end) {
        if (end < tree[i].begin || begin > tree[i].end) return Integer.MAX_VALUE;
        if (begin <= tree[i].begin && end >= tree[i].end) {
            return tree[i].data;
        }
        push_down(i);
        return Math.min(query(2 * i + 1, begin, end), query(2 * i + 2, begin, end));
    }

    public void update(int begin, int end, int value) {
        update(0, begin, end, value);
    }

    private void update(int i, int begin, int end, int value) {
        if (tree[i].end < begin || tree[i].begin > end) return;
        if (tree[i].begin <= begin && tree[i].end >= end) {
            tree[i].data += value; tree[i].mark += value;
            return;
        }
        push_down(i);
        update(2 * i + 1, begin, end);
        update(2 * i + 2, begin, end);
        tree[i].data = Math.min(tree[2 * i + 1].data, tree[2 * i + 2].data);
    }

    private void push_down(int i) {
        if (tree[i].mark == 0 || tree[i].begin == tree[i].end) return;
        tree[2 * i + 1].addMard(tree[i].mark);
        tree[2 * i + 1].data += tree[i].data;
        tree[2 * i + 2].addMard(tree[i].mark);
        tree[2 * i + 2].data += tree[i].data;
        tree[i].clear();
    }
}
