import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q239_test1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[1];
        Queap queap = new Queap();
        for (int i = 0; i < k; i++) {
            queap.enqueue(nums[i]);
        }
        int[] maxList = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            maxList[i] = queap.dequeue();
            if (i + k < n) queap.enqueue(nums[i + k]);
        }
        return maxList;
    }

    private class Queap {
        // private Queue<Integer> queue;
        private LinkedList<Integer> maxList;
        private LinkedList<Integer> countList;

        protected Queap() {
            // queue = new LinkedList<>();
            maxList = new LinkedList<>();
            countList = new LinkedList<>();
        }

        protected void enqueue(int x) {
            int count = 1;
            while (!maxList.isEmpty() && x >= maxList.getLast()) {
                count += countList.removeLast();
                maxList.removeLast();
            }
            maxList.add(x); countList.add(count);
        }

        protected int dequeue() {
            if (maxList.isEmpty()) return 0;
            int max = maxList.getFirst();
            if (!countList.isEmpty() && countList.getFirst() > 1) {
                countList.set(0, countList.getFirst() - 1);
            } else {
                countList.removeFirst(); maxList.removeFirst();
            }
            return max;
        }

        protected int getMax() {
            return maxList.getFirst();
        }
    }
}