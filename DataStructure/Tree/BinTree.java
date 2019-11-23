public class BinTree {
    protected BinNode root;
    protected int size;

    BinTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BinNode root() {
        return root;
    }

    protected int updateHeight(BinNode x) {
        if (x == null) return -1;
        if (x.lc == null && x.rc == null) return x.height = 0;
        if (x.lc == null) return x.height = x.rc.height + 1;
        if (x.rc == null) return x.height = x.lc.height + 1;
        return x.height = Math.max(x.lc.height, x.rc.height) + 1;
    }

    protected void updateHeightAbove(BinNode x) {
        while (x != null) {
            updateHeight(x);
            x = x.parent;
        }
    }

    public BinNode insertAsRC(BinNode x, int value) {
        size++;
        x.insertAsRC(value);
        updateHeightAbove(x);
        return x.rc;
    }

    public BinNode insertAsLC(BinNode x, int value) {
        size++;
        x.insertAsLC(value);
        updateHeightAbove(x);
        return x.lc;
    }

    public BinNode insertAsRoot(int value) {
        size = 1;
        return root = new BinNode(value);
    }
}
