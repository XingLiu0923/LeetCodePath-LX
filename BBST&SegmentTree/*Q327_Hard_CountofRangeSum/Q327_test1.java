public class Q327_test1 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        int r = 0;
        int n = nums.length;
        SplayTree spt = new SplayTree();
        spt.insert(0);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            long lo = sum - upper, hi = sum - lower;
            r += spt.countRange(lo, hi + 1);
            spt.insert(sum);
        }
        return r;
    }

    private class SplayTree {
        private Node root;

        private class Node {
            private long key;
            private int count; // 这个值的个数；
            private int size;   // 整个树包括的树木，包含所有的count；
            private Node left, right;

            protected Node(long key) {
                this.key = key; count = 1; size = count;
            }
        }

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
            if (h == null || h.key == key) return h;
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

        public void insert(long key) {
            if (root == null) { root = new Node(key); return; }
            root = splay(root, key);
            if (key < root.key) {
                Node n = new Node(key);
                n.left = root.left;
                n.right = root;
                root.left = null;
                n.size = root.size + 1;
                root.size = size(root.left) + size(root.right) + root.count;
                root = n;
            } else if (key > root.key) {
                Node n = new Node(key);
                n.right = root.right;
                n.left = root;
                root.right = null;
                n.size = root.size + 1;
                root.size = size(root.left) + size(root.right) + root.count;
                root = n;
            } else {
                root.count++;
                root.size++;
            }
        }

        public int countRange(long low, long hi) {        // [lo, hi)
            int rLow = countLess(low), rHi = countLess(hi);
            return rHi - rLow;
        }

        private int countLess(long low) {
            root = splay(root, low);
            return countLess(low, root);
        }

        private int countLess(long low, Node x) {
            if (x == null) return 0;
            if (x.key == low) {
                return size(x.left);
            }
            if (low < x.key) return countLess(low, x.left);
            else return x.count + size(x.left) + countLess(low, x.right);
        }
    }

    public static void main(String[] args) {
        int[] a = {-2, 5, 1};
        new Q327_test1().countRangeSum(a, -2, 2);
    }
}
