import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q347_test1 {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(nums[i])) hashMap.put(nums[i], 1);
            else hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
        }

        PQ_Min pq = new PQ_Min();
        for (Integer key : hashMap.keySet()) {
            if (pq.size() < k) pq.insert(key);
            else {
                if (hashMap.get(key) < hashMap.get(pq.getMin())) continue;
                pq.deleMin();
                pq.insert(key);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (pq.size() != 0) {
            result.add(pq.deleMin());
        }
        return result;
    }

    private class PQ_Min {
        int[] ele;
        int capacity;
        int size;

        PQ_Min() {
            capacity = 3;
            size = 0;
            ele = new int[3];
        }

        public int size() {
            return size;
        }

        public void insert(int k) {
            expand();
            ele[size++] = k;
            percolate_up(size - 1);
        }

        public int getMin() {
            return ele[0];
        }

        public int deleMin() {
            int min = ele[0];
            swap(0, size - 1);
            size--;
            percolate_down(0);
            return min;
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
                swap(i, (i - 1)/2);
                i = (i - 1)/2;
            }
        }

        private boolean more(int i, int j) {
            return hashMap.get(ele[i]) > hashMap.get(ele[j]);
        }

        private void swap(int i, int j) {
            int t = ele[i];
            ele[i] = ele[j];
            ele[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {4,1,-1,2,-1,2,3};
        new Q347_test1().topKFrequent(a, 2);
    }

}
