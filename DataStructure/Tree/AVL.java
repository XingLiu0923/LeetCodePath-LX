public class AVL extends BST {
    private boolean AvlBalanced(BinNode x) {
        if (x == null) return true;
        return height(x.lc) - height(x.rc) > -2 && height(x.lc) - height(x.rc) < 2;
    }

    private BinNode connect34(BinNode a, BinNode b, BinNode c,
                              BinNode T0, BinNode T1, BinNode T2, BinNode T3) {
        a.lc = T0; if (T0 != null) T0.parent = a;
        a.rc = T1; if (T1 != null) T1.parent = a;
        c.lc = T2; if (T2 != null) T2.parent = c;
        c.rc = T3; if (T3 != null) T3.parent = c;
        b.lc = a; a.parent = b;
        b.rc = c; c.parent = b;
        return b;
    }

    private BinNode rotateAt(BinNode v) {
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
        if (x == null || x.parent == null) return false;
        return x == x.parent.lc;
    }

    private boolean IsRightChild(BinNode x) {
        if (x == null || x.parent == null) return false;
        return x == x.parent.rc;
    }

    private BinNode tallerChild(BinNode x) {
        if (x == null) return null;
        if (height(x.lc) < height(x.rc)) return x.rc;
        else if (height(x.rc) < height(x.lc)) return x.lc;
        else {
            if (IsLeftChild(x)) return x.lc;
            else return x.rc;
        }
    }

    private int height(BinNode x) {
        if (x == null) return -1;
        return x.height;
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
                if (g == root) root = rotateAt(tallerChild(tallerChild(g)));
                else if (IsLeftChild(g)) g.parent.lc = rotateAt(tallerChild(tallerChild(g)));
                else g.parent.rc = rotateAt(tallerChild(tallerChild(g)));
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
                if (g == root) { root = rotateAt(tallerChild(tallerChild(g))); g = root; }
                else if (IsLeftChild(g)) { BinNode gp = g.parent; gp.lc = rotateAt(tallerChild(tallerChild(g))); g = gp.lc; }
                else { BinNode gp = g.parent; gp.rc = rotateAt(tallerChild(tallerChild(g))); g = gp.rc; }
            }
            updateHeight(g);
        }
        return true;
    }

    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        avl.remove(3);
    }
}
