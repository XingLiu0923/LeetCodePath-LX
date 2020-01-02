import java.util.Vector;

public class Q23_test1 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        Vector<listPairs> listPairs = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (lists[i] == null) continue;
            ListNode head = lists[i];
            lists[i] = lists[i].next;
            head.next = null;
            listPairs.add(new listPairs(head, i));
        }
        PQ_Min PQ = new PQ_Min(listPairs);
        ListNode first = new ListNode(-1);
        ListNode prev = first;
        while (!PQ.isEmpty()) {
            listPairs minPairs = PQ.delMin();
            ListNode minNode = minPairs.x;
            prev.next = minNode;
            prev = prev.next;
            if (lists[minPairs.i] != null) {
                ListNode head = lists[minPairs.i];
                lists[minPairs.i] = lists[minPairs.i].next;
                head.next = null;
                PQ.insert(new listPairs(head, minPairs.i));
            }
        }
        return first.next;
    }

    private class listPairs {
        ListNode x;
        int i;

        listPairs(ListNode x, int i) {
            this.x = x;
            this.i = i;
        }
    }

    private class PQ_Min {
        listPairs[] ele;
        int capacity;
        int size;

        PQ_Min() { capacity = 3; size = 0; ele = new listPairs[capacity]; }

        PQ_Min(Vector<listPairs> list) {

            size = list.size();
            capacity = 2 * size;
            ele = new listPairs[size];
            for (int i = 0; i < size; i++) {
                ele[i] = list.get(i);
            }
            heapyfy(size - 1);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(listPairs k) {
            expand();
            ele[size] = k;
            percolateUp(size++);
        }

        public listPairs delMin() {
            listPairs min = ele[0];
            ele[0] = ele[size - 1];
            size--;
            percolateDown(0);
            return min;
        }

        public listPairs getMin() {
            return ele[0];
        }

        private void heapyfy(int n) {
            int lastInnerNode = (n -  1)/2;
            for (int i = lastInnerNode; i >= 0; i--) {
                percolateDown(i);
            }
        }

        private void expand() {
            if (size < capacity) return;
            capacity = 2 * capacity;
            listPairs[] newEle = new listPairs[capacity];
            for (int i = 0; i < size; i++) {
                newEle[i] = ele[i];
            }
            ele = newEle;
        }

        private void percolateUp(int i) {
            while (i > 0 && less(i, (i - 1)/2)) {
                swap(i, (i - 1)/2);
                i = (i - 1)/2;
            }
        }

        private void percolateDown(int i) {
            while (2 * i + 1 < size) {
                int j = 2 * i + 1;
                if (j + 1 < size && less(j + 1, j)) j = j + 1;
                if (less(i, j)) break;
                swap(i, j);
                i = j;
            }
        }

        private boolean less(int i, int j) {
            return ele[i].x.val < ele[j].x.val;
        }

        private void swap(int i, int j) {
            listPairs t = ele[i];
            ele[i] = ele[j];
            ele[j] = t;
        }
    }

    public static void main(String[] args) {
        ListNode[] ele = new ListNode[4];
        ele[0] = new ListNode(1);
        ele[1] = new ListNode(2);
        ele[2] = new ListNode(3);
        ele[3] = new ListNode(4);
        new Q23_test1().mergeKLists(ele);
    }
}
