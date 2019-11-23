public class BinNode {
    protected BinNode parent, lc, rc;
    protected int value, size, height;

    public BinNode(int value) {
        this.parent = null; this.lc = null; this.rc = null;
        this.value = value; this.size = 1; this.height = 0;
    }

    public BinNode(int value, BinNode parent) {
        this.value = value;
        this.parent = parent;
    }

    public BinNode insertAsLC(int c) {
        return this.lc = new BinNode(c, this);
    }

    public BinNode insertAsRC(int c) {
        return this.rc = new BinNode(c, this);
    }

    public int size() {
        int s = 1;
        if (lc != null) s = s + lc.size();
        if (rc != null) s = s + rc.size();
        return s;
    }
}
