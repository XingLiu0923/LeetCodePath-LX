import java.util.HashMap;

class LRUCache {

    HashMap<Integer, Node> hashMap;
    HashList hashList;
    int size, capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        hashMap = new HashMap<>();
        hashList = new HashList();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) return -1;
        Node x = hashMap.get(key);
        if (x.val == -1) return -1;
        hashList.moveToLast(x);
        return x.val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key) && hashMap.get(key).val != -1) {
            Node x = hashMap.get(key);
            x.val = value;
            hashList.moveToLast(x);
        } else {
            if (size < capacity) {
                hashList.addLast(value);
                Node last = hashList.getLast();
                hashMap.put(key, last);
                size++;
            } else {
                hashList.removeFirst();
                hashList.addLast(value);
                Node last = hashList.getLast();
                hashMap.put(key, last);
            }
        }
    }

    private class Node {
        int val;
        Node last, next;

        Node(int val) {
            this.val = val;
            last = null; next = null;
        }

        Node(int val, Node last, Node next) {
            this.val = val; this.last = last; this.next = next;
        }
    }

    private class HashList {
        private Node head, tail;
        private int size;

        HashList() {
            head = new Node(-1); tail = new Node(-1);
            head.next = tail; tail.last = head;
            size = 0;
        }

        protected void addLast(int val) {
            Node x = new Node(val, tail.last, tail);
            tail.last.next = x;
            tail.last = x;
            size++;
        }

        protected boolean isEmpty() {
            return size == 0;
        }

        protected void removeFirst() {
            if (isEmpty()) return;
            head.next.val = -1;
            head.next = head.next.next;
            head.next.last = head;
        }

        protected Node getLast() {
            if (isEmpty()) return null;
            return tail.last;
        }

        protected Node getTail() {
            return tail;
        }

        protected void moveToLast(Node x) {
            x.last.next = x.next;
            x.next.last = x.last;
            x.last = tail.last;
            x.next = tail;
            x.last.next = x;
            x.next.last = x;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */