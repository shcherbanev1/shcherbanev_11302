public class MyArrayList<T> implements MyList<T> {
    private Object[] array;

    private int size;
    private int capacity;

    public MyArrayList() {
        this(16);
    }

    public MyArrayList(int capacity) {
        array = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    private void increaseCapacity() {
        if (size > capacity * 0.7) {
            capacity *= 2;
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(T t) {
        increaseCapacity();
        array[size] = t;
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        validateIndex(index);
        increaseCapacity();
        for (int i = index; i < size; i++) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) array[index];
    }

    @Override
    public int get(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
        // throw new NoSuchElementException();
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T res = get(index);
        for (int i  = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return res;
    }

    @Override
    public boolean remove(Object o) {
        int index = get(o);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size;
    }
}
