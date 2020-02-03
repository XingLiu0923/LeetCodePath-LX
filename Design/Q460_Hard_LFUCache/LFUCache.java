import java.util.HashMap;

class LFUCache {
    int size;
    int capacity;
    HashMap<Integer, Node> hashMap;
    LinkedList linkedList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        hashMap = new HashMap<>();
        linkedList = new LinkedList();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) return -1;
        Node x = hashMap.get(key);
        if (x.val == -1) return -1;
        x.freq++;
        linkedList.moveNext(x);
        return x.val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key) && hashMap.get(key).val != -1) {       // 已经有这个节点，直接改就行了。
            Node x = hashMap.get(key);
            x.val = value;
            x.freq++;
            linkedList.moveNext(x);
        } else {
            if (size >= capacity) {
                if (linkedList.isEmpty()) return;
                linkedList.removeFirst();
            }
            linkedList.addFist(value);
            Node first = linkedList.getFirst();
            hashMap.put(key, first);
            linkedList.moveNext(first);
            if (size < capacity) size++;
        }
    }

    class Node {
        int val, freq;
        Node last, next;

        Node(int val) {
            this.val = val; freq = 1;
            last = null; next = null;
        }

        Node(int val, Node last, Node next) {
            this.val = val; this.last = last; this.next = next;
            freq = 1;
        }
    }

    class LinkedList {
        Node head, tail;
        int size;

        LinkedList() {
            head = new Node(-1); tail = new Node(-1);
            head.next = tail; tail.last = head;
            head.freq = 0; tail.freq = 0;
            size = 0;
        }

        void addFist(int val) {
            Node x = new Node(val, head, head.next);
            x.last.next = x;
            x.next.last = x;
            size++;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void removeFirst() {
            if (isEmpty()) return;
            Node first = head.next;
            first.last.next = first.next;
            first.next.last = first.last;
            first.last = null;
            first.next = null;
            first.val = -1;
        }

        void moveNext(Node x) {
            while (x.next.freq > 0 && x.freq >= x.next.freq) {
                swap(x, x.next);
            }
        }

        void swap(Node x, Node y) {
            x.next = y.next;
            y.last = x.last;
            x.last.next = y;
            y.next.last = x;
            y.next = x;
            x.last = y;
        }

        Node getFirst() {
            return head.next;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */