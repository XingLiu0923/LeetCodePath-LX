public class SplayTree {
    private Node root;

    private class Node {
        private int key;
        private int value;
        private Node left, right;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

    private Node splay(Node h, int key) {
        if (h == null) return h;
        if (key < h.key) {
            if (h.left == null) return h;
            if (key < h.left.key) {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            } else if (key > h.left.key) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null) h.left = rotateLeft(h.left);
            }
            return h = rotateRight(h);
        } else {
            if (key > h.key) {
                if (h.right == null) return h;
                if (key > h.right.key) {
                    h.right.right = splay(h.right.right, key);
                    h = rotateRight(h);
                } else if (key < h.right.key) {
                    h.right.left = splay(h.right.left, key);
                    if (h.right.left != null) h.right = rotateLeft(h.right);
                }
                return rotateLeft(h);
            }
        }
        return h;
    }

    public Integer getValue(int key) {
        root = splay(root, key);
        if (root != null && root.key == key) return root.value;
        return null;
    }

    public boolean contains(int key) {
        return getValue(key) != null;
    }

    public void put(int key, int val) {
        if (root == null) {
            root = new Node(key, val);
            return;
        }
        splay(root, key);
        if (key < root.key) {
            Node x = new Node(key, val);
            x.left = root.left;
            x.right = root;
            root.left = null;
            root = x;
        } else if (key > root.key) {
            Node x = new Node(key, val);
            x.left = root;
            x.right = root.right;
            root.right = null;
            root = x;
        } else {
            root.value = val;
        }
    }

    public void remove(int key) {
        if (root == null) return;
        splay(root, key);
        if (root.key == key) {
            if (root.left == null) root = root.right;
            else {
                Node x = root.right;
                root = splay(root.left, key);
                root.right = x;
            }
        }
    }
}
