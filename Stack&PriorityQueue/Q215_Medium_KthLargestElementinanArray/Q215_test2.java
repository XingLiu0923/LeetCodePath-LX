public class Q215_test2 {
    public int findKthLargest(int[] nums, int k) {
        PQ_MAX pq = new PQ_MAX(nums);
        int max = 0;
        while (k-- > 0) {
            max = pq.delete();
        }
        return max;
    }

    private class PQ_MAX {
        int[] ele;
        int capacity;
        int size;

        PQ_MAX() {
            capacity = 3;
            size = 0;
            ele = new int[capacity];
        }

        PQ_MAX(int[] array) {
            size = array.length;
            capacity = 2 * size;
            ele = new int[size];
            for (int i = 0; i < size; i++) {
                ele[i] = array[i];
            }
            heapify();
        }

        public int getMax() {
            return ele[0];
        }

        public void insert(int k) {
            expand();
            ele[size++] = k;
            percolate_up(size - 1);
        }

        public int delete() {
            int max = ele[0];
            swap(0, size - 1);
            size--;
            percolate_down(0);
            return max;
        }

        private void heapify() {
            for (int i = (size - 2)/2; i > -1; i--) {
                percolate_down(i);
            }
        }

        private void expand() {
            if (size < capacity) return;
            capacity = 2 * capacity;
            int[] newEle = new int[capacity];
            for (int i = 0; i < size; i++) {
                newEle[i] = ele[i];
            }
            ele = newEle;
        }

        private void percolate_up(int i) {
            while (i > 0 && ele[(i - 1)/2] < ele[i]) {
                swap(i, (i - 1)/2);
            }
        }

        private void percolate_down(int i) {
            while (2 * i + 1 < size) {
                int j = 2 * i + 1;
                if (j + 1 < size && ele[j] < ele[j + 1]) j = j + 1;
                if (ele[i] > ele[j]) break;
                swap(i, j);
                i = j;
            }
        }

        private void swap(int i, int j) {
            int t = ele[i];
            ele[i] = ele[j];
            ele[j] = t;
        }
    }
}
