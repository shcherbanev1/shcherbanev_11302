package ru.itis;

@FunctionalInterface
interface MyFunction<T, R> {
    R apply(T t);
}
