public class hashCode {
    public static long hashcode(int k) {
        return Integer.toUnsignedLong(k);
    }

    public static long hashcode(long k) {
        return Integer.toUnsignedLong((int)k >> 32 + (int)k);
    }

    public static int hashcode(char k) {
        return k;
    }

    public static long hashcode(char[] c) {
        long h = 0;
        for (int i = 0; i < c.length; i++) {
            h = (h << 5) | (h >> 27);
            h = h + (int)c[i];
        }
        return h;
    }
}
