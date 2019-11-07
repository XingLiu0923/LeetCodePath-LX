public class HashTable<K, V> implements Dictionary<K, V> {

    private Entry<K, V>[] ht;
    private int N;      // 存储的词条数量；
    private int M;      // 总共可以存储的词条数量；
    private BitMap lazyRemoval;

    private class Entry<K, V> {
        private K key;
        private V value;
        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public HashTable(int c) {
        M = c;
        N = 0;
        ht = new Entry[c];
        lazyRemoval = new BitMap(M);
    }

    // 用于查找，有懒惰标记或者桶里有数的时候继续。
    protected int probe4Hit(K k) {
        int r = k.hashCode() % M;
        while (ht[r] != null && !ht[r].key.equals(k) && (ht[r] == null && lazyRemoval.test(r))) {
            r = (r + 1) % M;
        }
        return r;
    }

    protected int probe4Free(K k) {
        int r = k.hashCode();
        while (ht[r] != null) r = (r + 1) % M;
        return r;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean remove(K k, V v) {
        if (get(k) == null) return false;
        int r = probe4Hit(k);
        ht[r] = null; lazyRemoval.set(r);
        N--;
        return true;
    }

    @Override
    public boolean put(K k, V v) {
        if (get(k) != null) return false;
        int r = probe4Free(k);
        ht[r] = new Entry<K, V>(k, v);
        N++;
        return true;
    }

    @Override
    public V get(K k) {
        int r = probe4Hit(k);
        if (ht[r] != null) return ht[r].value;
        return null;
    }

    public static void main(String[] args) {
        int a = 1 << 3;
        System.out.println(a);
    }
}
