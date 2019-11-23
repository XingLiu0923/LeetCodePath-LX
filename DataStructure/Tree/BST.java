public class BST extends BinTree {
    protected BinNode hot;      // 命中节点的父亲；

    public BinNode search(int e) {
        hot = null;
        return searchIn(root, e);
    }

    private BinNode searchIn(BinNode x, int e) {
        while (x != null && x.value != e) {
            hot = x;
            x = (x.value < e) ? x.rc : x.lc;
        }
        return x;
    }

    public BinNode insert(int e) {
        BinNode x = search(e);
        if (x == null) {
            size++;
            x = new BinNode(e, hot);
            if (isEmpty()) root = x;
            if (hot != null) {
                if (x.value > hot.value) hot.rc = x;
                else hot.lc = x;
            }
            updateHeightAbove(x);
        }
        return x;
    }

    public boolean remove(int e) {
        BinNode x = search(e);
        if (x == null) return false;
        removeAt(x);
        size--;
        updateHeightAbove(hot);
        return true;
    }

    protected BinNode removeAt(BinNode x) {
        BinNode w = x;      // 即将被删除的节点；
        BinNode succ = null;        // 节点被删除以后的继任者；
        if (x.lc == null || x.rc == null) {
            succ = (x.lc == null) ? x.rc : x.lc;
            if (x == hot.lc) hot.lc = succ;
            else hot.rc = succ;
        } else {
            w = x.rc;
            while (w.lc != null) w = w.lc;
            w.value = x.value + w.value; x.value = w.value - x.value; w.value = w.value - x.value;
            BinNode u = w.parent;
            if (u == x) u.rc = succ = w.rc;
            else u.lc = succ = w.rc;
        }
        hot = w.parent;
        if (succ != null) succ.parent = hot;
        return succ;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(2);
        bst.search(2);
        bst.insert(3);
        bst.remove(2);
    }
}
