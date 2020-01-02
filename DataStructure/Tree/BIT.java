public class BIT {
    private int[] C;
    private int[] pre;
    private int n;

    public BIT(int[] a) {
        n = a.length;
        C = new int[n + 1]; pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + a[i - 1];
            C[i] = pre[i] - pre[i - lowbit(i)];
        }
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    public int query(int x) {
        int r = 0;
        for (int i = x + 1; i > 0; i -= lowbit(i)) {
            r += C[i];
        }
        return r;
    }

    public void update(int x, int y) {
        for (int i = x + 1; i <= n; i += lowbit(i)) {
            C[i] += y;
        }
    }
}
