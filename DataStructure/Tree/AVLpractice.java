public class AVLpractice extends BST {
    private BinNode connect34(BinNode a, BinNode b, BinNode c,
                              BinNode T0, BinNode T1, BinNode T2, BinNode T3) {
        a.lc = T0; if (T0 != null) T0.parent = a;
        a.rc = T1; if (T1 != null) T1.parent = a;
        c.lc = T2; if (T2 != null) T2.parent = c;
        c.rc = T3; if (T3 != null) T3.parent = c;
        b.lc = a; a.parent = b;
        b.rc = c; c.parent = c;
        return b;
    }

    private BinNode rotate(BinNode v) {
        BinNode p = v.parent, g = p.parent;
        if (IsLeftChild(p)) {
            if (IsLeftChild(v)) {
                p.parent = g.parent;
                return connect34(v, p, g, v.lc, v.rc, p.rc, g.rc);
            } else {
                v.parent = g.parent;
                return connect34(p, v, g, p.lc, v.lc, v.rc, g.rc);
            }
        } else {
            if (IsLeftChild(v)) {
                v.parent = g.parent;
                return connect34(g, v, p, g.lc, v.lc, v.rc, p.rc);
            } else {
                p.parent = g.parent;
                return connect34(g, p, v, g.lc, p.lc, v.lc, v.rc);
            }
        }
    }

    private boolean IsLeftChild(BinNode x) {
        if (x == null) return false;
        if (x.parent == null) return false;
        return x == x.parent.lc;
    }

    private boolean IsRightChild(BinNode x) {
        if (x == null) return false;
        if (x.parent == null) return false;
        return x == x.parent.rc;
    }

    private int height(BinNode x) {
        if (x == null) return -1;
        return x.height;
    }

    private boolean AvlBalanced(BinNode x) {
        if (x == null) return true;
        return height(x.lc) - height(x.rc) > -2 && height(x.lc) - height(x.rc) < 2;
    }

    private BinNode tallerChild(BinNode x) {
        if (x == null) return null;
        if (height(x.lc) < height(x.rc)) return x.rc;
        if (height(x.rc) < height(x.lc)) return x.lc;
        if (IsLeftChild(x)) return x.lc;
        return x.rc;
    }

    @Override
    public BinNode search(int e) {
        return searchIn(root, e);
    }

    private BinNode searchIn(BinNode x, int e) {
        while (x != null && x.value != e) {
            hot = x;
            x = (x.value < e) ? x.rc : x.lc;
        }
        return x;
    }

    @Override
    public BinNode insert(int e) {
        BinNode x = search(e);
        if (x != null) return x;
        size++;
        x = new BinNode(e, hot);
        if (isEmpty()) root = x;
        else {
            if (hot.value < e) hot.rc = x;
            else hot.lc = x;
        }
        for (BinNode g = hot; g != null; g = g.parent) {
            if (!AvlBalanced(g)) {
                if (g == root) root = rotate(tallerChild(tallerChild(g)));
                else if (IsLeftChild(g)) g.parent.lc = rotate(tallerChild(tallerChild(g)));
                else g.parent.rc = rotate(tallerChild(tallerChild(g)));
                break;
            } else {
                updateHeight(g);
            }
        }
        return x;
    }

    @Override
    public boolean remove(int e) {
        BinNode x = search(e);
        if (x == null) return false;
        size--;
        removeAt(x);
        for (BinNode g = hot; g != null; g = g.parent) {
            if (!AvlBalanced(g)) {
                if (g == root) { root = rotate(tallerChild(tallerChild(g))); g = root; }
                else if (IsLeftChild(g)) { BinNode gp = g.parent; gp.lc = rotate(tallerChild(tallerChild(g))); g = gp.lc; }
                else { BinNode gp = g.parent; gp.rc = rotate(tallerChild(tallerChild(g))); g = gp.rc; }
            }
            updateHeight(g);
        }
        return true;
    }

    @Override
    protected BinNode removeAt(BinNode x) {
        BinNode w = x;
        BinNode succ = null;
        if (x.lc == null || x.rc == null) {
            succ = (x.lc == null) ? x.rc : x.lc;
            if (hot != null) {
                if (IsLeftChild(x)) hot.lc = succ;
                else hot.rc = succ;
            }
        } else {
            w = x.rc;
            while (w.lc != null) w = w.lc;
            w.value = w.value + x.value; x.value = w.value - x.value; x.value = w.value - x.value;
            BinNode u = w.parent;
            if (u == x) u.rc = succ = w.rc;
            else u.lc = succ = w.rc;
        }
        hot = w.parent;
        if (succ != null) succ.parent = hot;
        return succ;
    }
}
