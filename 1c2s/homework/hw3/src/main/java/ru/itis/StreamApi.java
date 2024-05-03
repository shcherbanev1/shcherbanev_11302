package ru.itis;

import java.util.*;

public class StreamApi<T> {

    protected T[] data;

    public StreamApi(T[] array) {
        data = array;
    }

    public StreamApi<T> filter(MyPredicate<? super T> predicate) {
        T[] filteredData = (T[]) new Object[data.length];
        int filteredCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (predicate.test(data[i])) {
                filteredData[filteredCount] = data[i];
                filteredCount++;
            }
        }
        return new StreamApi<>(copy(filteredData, filteredCount));
    }

    public <R> StreamApi<R> map(MyFunction<? super T, ? extends R> mapper) {
        R[] mappedData = (R[]) new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            mappedData[i] = mapper.apply(data[i]);
        }
        return new StreamApi<>(mappedData);
    }

    public <R> StreamApi<R> flatMap(MyFunction<? super T, ? extends StreamApi<? extends R>> mapper) {
        List<R> flattedData = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            flattedData.addAll(Arrays.asList((R) mapper.apply(data[i])));
        }
        return new StreamApi<>((R[]) flattedData.toArray());
    }

    public StreamApi<T> peek(MyConsumer<? super T> consumer) {
        for (T item : data) {
            consumer.accept(item);
        }
        return this;
    }

    public void forEach(MyConsumer<? super T> consumer) {
        for (T item : data) {
            consumer.accept(item);
        }
    }

    public Optional<? super T> findAny() {
        for (T item : data) {
            return Optional.of(item);
        }
        return Optional.empty();
    }

    public int count() {
        return data.length;
    }

        public Optional<T> max(Comparator<? super T> comparator) {
        if (!isComparable(data)) {
            throw new IllegalArgumentException();
        }
        if (data.length == 0) {
            return Optional.empty();
        }
        T max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (comparator.compare(max, data[i]) < 0) {
                max = data[i];
            }
        }
        return Optional.of(max);
    }

    public Optional<T> min(Comparator<? super T> comparator) {
        if (!isComparable(data)) {
            throw new IllegalArgumentException();
        }
        if (data.length == 0) {
            return Optional.empty();
        }
        T min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (comparator.compare(min, data[i]) > 0) {
                min = data[i];
            }
        }
        return Optional.of(min);
    }

    private static <T> T[] copy(T[] src, int length) {
        T[] dest = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            dest[i] = src[i];
        }
        return dest;
    }

    public IntStreamApi mapToInt(MyFunction<? super T, Integer> mapper) {
        Integer[] mappedData = new Integer[data.length];
        for (int i = 0; i < data.length; i++) {
            mappedData[i] = mapper.apply(data[i]);
        }
        return new IntStreamApi(mappedData);
    }


    private static <T> boolean isComparable(T[] data) {
        return data[0] instanceof Comparable;
    }

}