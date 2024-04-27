package ru.itis;

@FunctionalInterface
public interface MyConsumer<T> {

    void accept(T value);

}
