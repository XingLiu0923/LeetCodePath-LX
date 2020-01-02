public class Q261_test1 {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int ENumber = edges.length;
        for (int i = 0; i < ENumber; i++) {
            if (uf.connected(edges[i][0], edges[i][1])) return false;
            uf.union(edges[i][0], edges[i][1]);
        }
        if (uf.count > 1) return false;
        return true;
    }

    private class UnionFind {
        int[] id;
        int[] sz;
        int count;

        UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
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

        protected boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        protected void union(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot == qRoot) return;
            if (sz[pRoot] < sz[qRoot]) {
                id[pRoot] = qRoot;
                sz[qRoot] += sz[qRoot];
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
