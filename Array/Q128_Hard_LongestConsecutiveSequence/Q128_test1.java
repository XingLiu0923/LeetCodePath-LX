import java.util.HashMap;

public class Q128_test1 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(nums[i])) continue;
            hashMap.put(nums[i], i);
            if (hashMap.containsKey(nums[i] - 1)) uf.union(i, hashMap.get(nums[i] - 1));
            if (hashMap.containsKey(nums[i] + 1)) uf.union(i, hashMap.get(nums[i] + 1));
        }
        return uf.maxSz;
    }

    private class UF {
        private int[] id;
        private int[] sz;
        private int count;
        private int maxSz;

        UF(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
            count = n;
            maxSz = 1;
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
                if (sz[qRoot] > maxSz) maxSz = sz[qRoot];
            } else {
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
                if (sz[pRoot] > maxSz) maxSz = sz[pRoot];
            }
        }

        protected int getMaxSz() {
            return maxSz;
        }
    }

    public static void main(String[] args) {
        int[] a = {100,4,200,1,3,2};
        new Q128_test1().longestConsecutive(a);
    }
}
