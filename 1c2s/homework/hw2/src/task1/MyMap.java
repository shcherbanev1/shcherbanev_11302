public interface MyMap<K, V> {

    public V put(K key, V value);
    public boolean containsKey(Object key);
    public V get(Object key);
    public V remove(Object key);
    public boolean containsValue(Object value);

}
