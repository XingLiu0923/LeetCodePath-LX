import java.util.HashMap;
import java.util.LinkedList;

class LRUCache1 {

    private int capacity;
    private int size;
    private LinkedList<Integer> windows;
    private HashMap<Integer, Integer> windowFreq;
    private HashMap<Integer, Integer> keyToValue;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        size = 0;
        windows = new LinkedList<>();
        windowFreq = new HashMap<>();
        keyToValue = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) return -1;
        windows.addLast(key);
        windowFreq.put(key, windowFreq.get(key) + 1);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            windows.addLast(key);
            windowFreq.put(key, windowFreq.get(key) + 1);
        } else {
            if (size < capacity) {
                keyToValue.put(key, value);
                windows.addLast(key);
                windowFreq.put(key, 1);
                size++;
            } else {
                while (windowFreq.get(windows.getFirst()) > 1) {
                    int num = windows.getFirst();
                    windowFreq.put(num, windowFreq.get(num) - 1);
                    windows.removeFirst();
                }
                int num = windows.getFirst();
                windows.removeFirst();
                windowFreq.remove(num);
                keyToValue.remove(num);
                keyToValue.put(key, value);
                windowFreq.put(key, 1);
                windows.addLast(key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(3);
        lruCache1.put(1,1);
        lruCache1.put(2,2);
        lruCache1.put(3,3);
        lruCache1.put(4,4);
        lruCache1.get(4);
        lruCache1.get(3);
        lruCache1.get(2);
        lruCache1.get(1);
        lruCache1.put(5, 5);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */