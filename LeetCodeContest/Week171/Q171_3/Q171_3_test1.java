import java.util.LinkedList;
import java.util.List;

public class Q171_3_test1 {
    public int makeConnected(int n, int[][] connections) {
        int connectNum = connections.length;
        if (connectNum < n - 1) return -1;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < connectNum; i++) {
            uf.Union(connections[i][0], connections[i][1]);
        }
        return uf.getCount() - 1;
    }

    private class UnionFind {
        int count;
        int[] id;
        int[] sz;

        UnionFind(int n) {
            count = n;
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        private int Find(int p) {
            int t = p;
            while (p != id[p]) {
                p = id[p];
            }
            id[t] = p;
            return p;
        }

        protected void Union(int p, int q) {
            int pRoot = Find(p), qRoot = Find(q);
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

        protected int getCount() {
            return count;
        }
    }
}
