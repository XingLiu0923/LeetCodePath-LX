public class Q493_test2 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        SplayTree spt = new SplayTree();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += spt.moreThan((long)2 * nums[i]);
            spt.insert(nums[i]);
        }
        return sum;
    }

    private class SplayTree {
        private class Node {
            private long key;
            private int count;
            private int size;
            private Node left, right;

            protected Node(long key) {
                this.key = key; count = 1; size = 1;
            }
        }

        private Node root;

        private int size(Node x) {
            if (x == null) return 0;
            return x.size;
        }

        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.size = h.size;
            h.size = size(h.left) + size(h.right) + h.count;
            return x;
        }

        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.size = h.size;
            h.size = size(h.left) + size(h.right) + h.count;
            return x;
        }

        private Node splay(Node h, long key) {
            if (h == null || key == h.key) return h;
            if (key < h.key) {
                if (h.left == null) return h;
                if (key < h.left.key) {
                    h.left.left = splay(h.left.left, key);
                    h = rotateRight(h);
                } else if (key > h.left.key) {
                    h.left.right = splay(h.left.right, key);
                    if (h.left.right != null) h.left = rotateLeft(h.left);
                }
                if (h.left == null) return h;
                return rotateRight(h);
            } else {
                if (h.right == null) return h;
                if (key > h.right.key) {
                    h.right.right = splay(h.right.right, key);
                    h = rotateLeft(h);
                } else if (key < h.right.key) {
                    h.right.left = splay(h.right.left, key);
                    if (h.right.left != null) h.right = rotateRight(h.right);
                }
                if (h.right == null) return h;
                return rotateLeft(h);
            }
        }

        protected void insert(long key) {
            if (root == null) { root = new Node(key); return; }
            root = splay(root, key);
            if (key < root.key) {
                Node n = new Node(key);
                n.right = root;
                n.left = root.left;
                root.left = null;
                n.size = size(root) + 1;
                root.size = size(root.left) + size(root.right) + root.count;
                root = n;
            } else if (key > root.key) {
                Node n = new Node(key);
                n.left = root;
                n.right = root.right;
                root.right = null;
                n.size = size(root) + 1;
                root.size = size(root.left) + size(root.right) + root.count;
                root = n;
            } else {
                root.size++; root.count++;
            }
        }

        protected int moreThan(long key) {
            root = splay(root, key);
            return moreThan(key, root);
        }

        private int moreThan(long key, Node x) {
            if (x == null) return 0;
            if (key == x.key) {
                return size(x.right);
            } else if (key > x.key) {
                return moreThan(key, x.right);
            } else {
                return size(x.right) + x.count + moreThan(key, x.left);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2147483647, 2147483647};
        new Q493_test2().reversePairs(a);
    }
}
