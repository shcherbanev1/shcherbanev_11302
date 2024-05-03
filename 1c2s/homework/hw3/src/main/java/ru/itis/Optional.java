package ru.itis;

public class Optional<T> {

    private final T value;

    public Optional(T value) {
        this.value = value;
    }
    public static <T> Optional<T> empty() {
        return new Optional<>(null);
    }

    public static <T> Optional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return new Optional<>(value);
    }

    public T orElse(T otherValue) {
        if (value == null) return otherValue;
        return value;
    }

}
