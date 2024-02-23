import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyMap<K, V> {

    private List<Pair<K, V>>[] arr;
    private final int CAPACITY;

    public MyMap(int capacity) {
        CAPACITY = capacity;
        arr = new LinkedList[CAPACITY];
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode());
        if (arr[hash % CAPACITY] == null) {
            arr[hash % CAPACITY] = new LinkedList<Pair<K, V>>();
        }
        for (Pair<K, V> pair : arr[hash % CAPACITY]) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }
        arr[hash % CAPACITY].add(new Pair<>(key, value));
    }

    public void remove(K key) {
        int hash = Math.abs(key.hashCode());
        Iterator<Pair<K, V>> iterator = arr[hash % CAPACITY].iterator();
        while (iterator.hasNext()) {
            Pair<K, V> pair = iterator.next();
            if (pair.key.equals(key)) {
                iterator.remove();
                return;
            }
        }
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode());
        for (Pair<K, V> pair : arr[hash % CAPACITY]) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < CAPACITY; i++) {
            if (arr[i] != null) {
                for (Pair<K, V> pair : arr[i]) {
                    ans.append(pair.toString()).append("\n");
                }
            }
        }
        return ans.toString();
    }
}

