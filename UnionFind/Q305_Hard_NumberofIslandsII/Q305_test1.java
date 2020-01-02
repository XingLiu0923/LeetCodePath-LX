import java.util.ArrayList;
import java.util.List;

public class Q305_test1 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> landNumber = new ArrayList<>();
        boolean[][] land = new boolean[m][n];
        int steps = positions.length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < steps; i++) {
            int x = positions[i][0], y = positions[i][1];
            if (land[x][y]) { landNumber.add(uf.count()); continue; }
            land[x][y] = true; uf.addLand();
            if (isLand(land, x - 1, y)) uf.union(ufPosition(x, y, n), ufPosition(x - 1, y, n));
            if (isLand(land, x + 1, y)) uf.union(ufPosition(x, y, n), ufPosition(x + 1, y, n));
            if (isLand(land, x, y - 1)) uf.union(ufPosition(x, y, n), ufPosition(x, y - 1, n));
            if (isLand(land, x, y + 1)) uf.union(ufPosition(x, y, n), ufPosition(x, y + 1, n));
            landNumber.add(uf.count());
        }
        return landNumber;
    }

    private int ufPosition(int x, int y, int n) {
        return x * n + y;
    }

    private boolean isLand(boolean[][] land, int i, int j) {
        int m = land.length, n = land[0].length;
        return i > -1 && i < m && j > -1 && j < n && land[i][j];
    }

    private class UnionFind {
        int[] id;
        int count;
        int[] sz;

        UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
            count = 0;
        }

        protected void addLand() {
            count++;
        }

        protected int find(int p) {
            int t = p;
            while (p != id[p]) {
                p = id[p];
            }
            id[t] = p;
            return p;
        }

        protected int count() {
            return count;
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
    }
}
