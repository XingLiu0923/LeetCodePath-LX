import java.util.ArrayList;
import java.util.List;

public class Q294_test3 {
    public boolean canWin(String s) {
        List<Integer> gList = new ArrayList<>();
        int n = s.length();
        int i = 0, j = 0;
        int max = 0;
        while (i < n) {
            if (s.charAt(i) == '-') i++;
            else {
                for (j = i; j < n && s.charAt(j) == '+'; j++);
                gList.add(j - i);
                if (j - i > max) max = j - i;
                i = j + 1;
            }
        }
        if (max <= 1) return false;
        int[] g = new int[max + 1];
        g[0] = 0; g[1] = 0;
        for (int k = 2; k < max + 1; k++) {
            BitMap bm = new BitMap();
            for (int l = 0; l <= (k - 2) / 2; l++) {
                bm.set(g[l] ^ g[k - 2 - l]);
            }
            for (int l = 0; l < k; l++) {
                if (!bm.contains(l)) { g[k] = l; break; }
            }
        }
        int result = 0;
        while (!gList.isEmpty()) {
            result = result ^ g[gList.get(0)];
            gList.remove(0);
        }
        return result != 0;
    }

    class BitMap {
        char[] M;
        int N;

        BitMap(int n) {
            N = (n + 8) / 8;
            M = new char[N];
        }

        BitMap() {
            N = 1;
            M = new char[N];
        }

        private void expand(int k) {
            if ((k + 8) / 8 < N) return;
            int oldN = N;
            N = (k + 8) / 8 * 2;
            char[] newM = new char[N];
            for (int i = 0; i < oldN; i++) {
                newM[i] = M[i];
            }
            M = newM;
        }

        public boolean contains(int k) {
            expand(k);
            return (M[k >> 3] & (0x80 >> (k & 0x07))) != 0;
        }

        public void set(int k) {
            expand(k);
            M[k >> 3] = (char) (M[k >> 3] | (0x80 >> (k & 0x07)));
        }

        public void delete(int k) {
            expand(k);
            M[k >> 3] = (char) (M[k >> 3] & (~(0x80 >> (k & 0x07))));
        }
    }

    public static void main(String[] args) {
        new Q294_test3().canWin("++++++");
    }
}
