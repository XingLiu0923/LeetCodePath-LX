public class BitMap {
    private int N;  // 桶的个数；
    private char[] M;   // 桶；

    public BitMap() {
        N = 2;
        M = new char[N];
    }

    public BitMap(int n) {
        N = (n + 7) / 8;
        M = new char[N];
    }

    private void extend(int k) {
        if (k < N * 8) return;
        N = 2 * (k + 7) / 8;
        char[] tmp = new char[N];
        for (int i = 0; i < M.length; i++) {
            tmp[i] = M[i];
        }
        M = tmp;
    }

    public boolean test(int k) {
        extend(k);
        return (M[k >> 3] & (0x80 >> (k & 0x07))) != 0;
    }

    public void set(int k) {
        extend(k);
        M[k >> 3] |= ((0x80) >> (k & 0x07));
    }

    public void clear(int k) {
        M[k >> 3] &= ~((0x80) >> (k & 0x07));
    }

    public static void main(String[] args) {
        BitMap b = new BitMap(11);
        System.out.println((int)b.M[0]);
    }
}
