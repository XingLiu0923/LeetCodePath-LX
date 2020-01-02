class MedianFinder {

    SplayTree st;

    /** initialize your data structure here. */
    public MedianFinder() {
        st = new SplayTree();
    }

    public void addNum(int num) {
        st.insert(num);
    }

    public double findMedian() {
        int n = st.size();
        if (n % 2 == 1) {
            return 1.0 * st.query((n - 1)/2);
        } else {
            int median1 = st.query((n - 1)/2);
            int median2 = st.query((n - 1)/2 + 1);
            return 0.5 * (median1 + median2);
        }
    }

    private class SplayTree {
        private class Node {
            int data, size;
            int count;
            Node left, right;

            Node(int data) {
                this.data = data; size = count = 1;
            }
        }

        private Node root;

        protected int size() {
            if (root == null) return 0;
            return size(root);
        }

        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.size = size(h);
            h.size = size(h.left) + size(h.right) + h.count;
            return x;
        }

        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.size = size(h);
            h.size = size(h.left) + size(h.right) + h.count;
            return x;
        }

        private Node splay(Node h, int key) {
            if (h == null || key == h.data) return h;
            if (key < h.data) {
                if (h.left == null) return h;
                if (key < h.left.data) {
                    h.left.left = splay(h.left.left, key);
                    h = rotateRight(h);
                } else if (key > h.left.data){
                    h.left.right = splay(h.left.right, key);
                    if (h.left.right != null) h.left = rotateLeft(h.left);
                }
                if (h.left == null) return h;
                return rotateRight(h);
            } else {
                if (h.right == null) return h;
                if (key > h.right.data) {
                    h.right.right = splay(h.right.right, key);
                    h = rotateLeft(h);
                } else if (key < h.right.data){
                    h.right.left = splay(h.right.left, key);
                    if (h.right.left != null) h.right = rotateRight(h.right);
                }
                if (h.right == null) return h;
                return rotateLeft(h);
            }
        }



        protected void insert(int key) {
            if (root == null) { root = new Node(key); return; }
            root = splay(root, key);
            if (root.data == key) {
                root.count++; root.size++; return;
            }
            Node x = new Node(key);
            if (key < root.data) {
                x.left = root.left;
                root.left = null;
                x.right = root;
                x.size = size(root) + 1;
                root.size = size(root.left) + size(root.right) + root.count;
            } else {
                x.right = root.right;
                root.right = null;
                x.left = root;
                x.size = size(root) + 1;
                root.size = size(root.left) + size(root.right) + root.count;
            }
            root = x;
        }

        protected int query(int rank) {
            return query(root, rank);
        }

        protected int query(Node x, int rank) {
            int xRank = size(x.left);
            if (xRank <= rank && rank < xRank + x.count) {
                root = splay(root, x.data);
                return x.data;
            }
            if (rank < xRank) return query(x.left, rank);
            else return query(x.right, rank - xRank - x.count);
        }

        private int size(Node h) {
            if (h == null) return 0;
            return h.size;
        }

        
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.findMedian();
        mf.addNum(10);
        mf.findMedian();
        mf.addNum(6);
        mf.findMedian();
        mf.addNum(5);
        mf.findMedian();
        mf.addNum(0);
        mf.findMedian();
        mf.addNum(6);
        mf.findMedian();
        mf.addNum(3);
        mf.findMedian();
        mf.addNum(1);
        mf.findMedian();
        mf.addNum(0);
        mf.findMedian();
        mf.addNum(0);
        mf.findMedian();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */