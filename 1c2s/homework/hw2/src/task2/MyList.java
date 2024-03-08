interface MyList<T> {


    boolean add(T t);
    void add(int index, T element);
    boolean contains(Object o);
    T get(int index);
    int get(Object o);
    boolean remove(Object o);
    T remove(int index);
    int size();


}
