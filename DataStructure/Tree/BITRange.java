public class BITRange {
    private int[] C1;
    private int[] C2;
    private int n;

    BITRange(int[] a) {
        int n = a.length;
        int[] d = new int[n + 1];
        d[1] = a[0];
        for (int i = 2; i <= n; i++) {
            d[i] = a[i - 1] - a[i - 2];
        }
        int[] pre1 = new int[n + 1], pre2 = new int[n + 1];
        C1 = new int[n + 1]; C2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre1[i] = pre1[i - 1] + d[i];   C1[i] = pre1[i] - pre1[i - lowbit(i)];
            pre2[i] = pre2[i - 1] + i * d[i];   C2[i] = pre2[i] - pre2[i - lowbit(i)];
        }
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    private int query(int[] C, int x) {
        int r = 0;
        for (int i = x; i >= 0; i -= lowbit(x)) {
            r += C[i];
        }
        return r;
    }

    public int query(int x) {
        int p = x + 1;
        return (p + 1) * query(C1, p) - query(C2, p);
    }

    public int query(int x, int y) {
        return query(y) - query(x - 1);
    }

    private void update(int[] C, int x, int y) {
        for (int i = x; i <= n; i += lowbit(i)) {
            C[i] += y;
        }
    }

    public void update(int left, int right, int y) {
        left = left + 1; right = right + 1;
        update(C1, left, y); update(C1, right + 1, -y);
        update(C2, left, left * y); update(C2, right + 1, -(right + 1) * y);
    }
}
