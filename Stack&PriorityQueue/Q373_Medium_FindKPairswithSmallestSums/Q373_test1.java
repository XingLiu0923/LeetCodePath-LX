import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q373_test1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> kList = new ArrayList<>();
        if (n1 == 0 || n2 == 0) return kList;
        int[][] pointer = new int[n2][2];       // 0 代表pointer在num1中的位置，1恒为nums2中的位置
        for (int i = 0; i < n2; i++) {
            pointer[i][0] = 0;
            pointer[i][1] = i;
        }
        PQ_MIN pq_min = new PQ_MIN(pointer, nums1, nums2);

        while (kList.size() < Math.min(k, n1 * n2)) {
            int[] min = pq_min.delMin();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[min[0]]);
            list.add(nums2[min[1]]);
            kList.add(list);
            min[0]++;
            if (min[0] < n1) pq_min.insert(min);
        }
        return kList;
    }

    private class PQ_MIN {
        int[][] ele;
        int size;
        int capacity;
        int[] nums1;
        int[] nums2;

        PQ_MIN(int[][] pointer, int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            size = pointer.length;
            capacity = 2 * size;
            ele = new int[size][2];
            for (int i = 0; i < size; i++) {
                ele[i][0] = pointer[i][0]; ele[i][1] = pointer[i][1];
            }
            heapify();
        }

        public void insert(int[] k) {
            ele[size++] = k;
            percolate_up(size - 1);
        }

        public int[] getMin() {
            return ele[0];
        }

        public int[] delMin() {
            int[] k = ele[0];
            swap(0, --size);
            percolate_down(0);
            return k;
        }

        private void heapify() {
            for (int i = (size - 2)/2; i > -1; i--) {
                percolate_down(i);
            }
        }

        private void percolate_up(int i) {
            while (i > 0 && more((i - 1)/2, i)) {
                swap(i, (i - 1)/2);
                i = (i - 1)/2;
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

        private void swap(int i, int j) {
            int[] t = ele[i];
            ele[i] = ele[j];
            ele[j] = t;
        }

        private boolean more(int i, int j) {
            return nums1[ele[i][0]] + nums2[ele[i][1]] > nums1[ele[j][0]] + nums2[ele[j][1]];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,1,2};
        int[] num2 = {1,2,3};
        new Q373_test1().kSmallestPairs(num1, num2, 10);
    }
}
