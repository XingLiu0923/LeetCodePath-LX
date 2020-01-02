public class Q323_test1 {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int ENumber = edges.length;
        for (int i = 0; i < ENumber; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.count();
    }

    private class UnionFind {
        private int[] id;
        private int[] sz;
        private int count;

        UnionFind(int n) {
            id = new int[n]; sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;  sz[i] = 1;
            }
            count = n;
        }

        protected int find(int p) {
            int t = p;
            while (p != id[p]) {
                p = id[p];
            }
            id[t] = p;
            return p;
        }

        protected void union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) return;
            if (sz[pRoot] < sz[qRoot]) {
                id[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
            count--;
        }

        protected int count() {
            return count;
        }
    }
}
