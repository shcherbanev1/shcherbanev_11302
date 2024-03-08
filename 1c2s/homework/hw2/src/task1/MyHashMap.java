import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private final int CAPACITY;
    private LinkedList<Entry<K, V>>[] table;
    public MyHashMap(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        table = new LinkedList[CAPACITY];
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode() % CAPACITY);
    }

    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            System.out.println(key);
            System.out.println(entry.getKey());
            if (key.equals(entry.getKey())) {
                System.out.println(key);
                V old = entry.getValue();
                entry.setValue(value);
                return old;
            }
        }
        table[index].add(new Entry<>(key, value));
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = getIndex(key);
        if (table[index] == null) return false;
        for (Entry<K, V> entry : table[index]) {
            if (key.equals(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int index = getIndex(key);
        if (table[index] == null) return null;
        for (Entry<K, V> entry : table[index]) {
            if (key.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = getIndex(key);
        if (table[index] == null) return null;
        for (Entry<K, V> entry : table[index]) {
            if (key.equals(entry.getKey())) {
                table[index].remove(entry);
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clear() {
        table = new LinkedList[CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    sb.append(entry.toString());
                    sb.append(", ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                sb.append("; ");
            }
        }
        if (sb.length() >= 2) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
