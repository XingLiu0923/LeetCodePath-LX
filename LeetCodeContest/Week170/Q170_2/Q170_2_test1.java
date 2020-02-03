public class Q170_2_test1 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        BIT bit = new BIT(arr);
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = bit.query(queries[i][0], queries[i][1]);
        }
        return result;
    }

    private class BIT {
        int[] C;
        int N;

        BIT(int[] a) {
            N = a.length;
            C = new int[N + 1];
            int[] pre = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                pre[i] = pre[i - 1] ^ a[i - 1];
                C[i] = pre[i] ^ pre[i - lowbit(i)];
            }
        }

        private int lowbit(int x) {
            return  x & (-x);
        }

        private int query(int x) {
            int r = 0;
            for (int i = x; i > 0; i = i - lowbit(i)) {
                r = r ^ C[i];
            }
            return r;
        }

        protected int query(int lo, int hi) {
            return query(lo) ^ query(hi + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 3, 4, 8};
        int[][] q = new int[][] {{0, 1}};
        new Q170_2_test1().xorQueries(a, q);
    }
}
