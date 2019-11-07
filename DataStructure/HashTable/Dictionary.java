public interface Dictionary <K, V> {
    int size();
    boolean remove(K k, V v);
    boolean put(K k, V v);
    V get(K k);
}
