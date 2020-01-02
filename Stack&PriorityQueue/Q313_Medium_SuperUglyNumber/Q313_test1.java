import java.util.Vector;

public class Q313_test1 {
    Vector<Integer> uglyNum;

    public int nthSuperUglyNumber(int n, int[] primes) {
        int pNum = primes.length;
        int[][] pointer = new int[pNum][2];      // point[i]指向list里面的数，vector[pointer[i][0]] * pointer[i][1] > max(vector)
        uglyNum = new Vector<>();
        uglyNum.add(1);
        for (int i = 0; i < pNum; i++) {
            pointer[i][0] = 0;  pointer[i][1] = primes[i];
        }
        PQ_MIN pq_min = new PQ_MIN(pointer);
        while (uglyNum.size() < n) {
            int[] k = pq_min.deleteMin();
            int newUgly = uglyNum.get(k[0]) * k[1];
            if (newUgly > uglyNum.get(uglyNum.size() - 1)) uglyNum.add(newUgly);
            k[0]++;
            pq_min.insert(k);
        }
        return uglyNum.get(n - 1);
    }

    private class PQ_MIN {
        int[][] ele;
        int capacity;
        int size;

        PQ_MIN(int[][] pointer) {
            capacity = 2 * pointer.length;
            size = pointer.length;
            ele = new int[size][2];
            for (int i = 0; i < size; i++) {
                ele[i][0] = pointer[i][0];  ele[i][1] = pointer[i][1];
            }
            heapify();
        }

        public int[] getMin() {
            return ele[0];
        }

        public int[] deleteMin() {
            int[] t = ele[0];
            swap(0, --size);
            percolate_down(0);
            return t;
        }

        public void insert(int[] k) {
            ele[size++] = k;
            percolate_up(size - 1);
        }

        private void heapify() {
            for (int i = (size - 2)/2; i > -1; i--) {
                percolate_down(i);
            }
        }

        private void percolate_down(int i) {
            while (2 * i + 1 < size) {
                int j = 2 * i + 1;
                if (j + 1 < size && more(j, j + 1)) j = j + 1;
                if (!more(i, j)) break;
                swap(i, j);
                i = j;
            }
        }

        private void percolate_up(int i) {
            while (i > 0 && more((i - 1)/2, i)) {
                swap((i - 1)/2, i);
                i = (i - 1)/2;
            }
        }

        private boolean more(int i, int j) {
            return uglyNum.get(ele[i][0]) * ele[i][1] > uglyNum.get(ele[j][0]) * ele[j][1];
        }

        private void swap(int i, int j) {
            int[] t = ele[i];
            ele[i] = ele[j];
            ele[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        new Q313_test1().nthSuperUglyNumber(12, primes);
    }
}
