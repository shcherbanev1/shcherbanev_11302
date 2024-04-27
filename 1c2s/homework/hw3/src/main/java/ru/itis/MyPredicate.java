package ru.itis;

@FunctionalInterface
interface MyPredicate<T> {
    boolean test(T t);
}
