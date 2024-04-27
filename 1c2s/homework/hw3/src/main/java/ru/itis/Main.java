package ru.itis;

// можно с <T> но если не получится то с Integer или Long
        /*
            -map
            -flatMap
            -filter
            -peek

            -toList
            -toSet
            -toMap() мапа из ключ значение. ключ значение должен определять пользователь

            если не общего типа:
            -sum
            -max

            стрим не должен менять исходный массив Stream(<T> [] array)
         */

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
//        StreamApi<Integer> stream = new StreamApi<>(new Integer[] {1, 3, 6, 2, 8, 7});
//        stream.filter(i -> i % 2 == 0)
//                .peek(System.out::println);

        Student[] students = new Student[10];
        init(students);
//        System.out.println(Arrays.toString(students));
        StreamApi<Student> stream16a = new StreamApi<>(students);
        System.out.println("16a");
        System.out.println(stream16a
                .filter(s -> s.getScore() >= 56)
                .findAny().orElse(Student.empty));

        System.out.println();
        StreamApi<Student> stream16b = new StreamApi<>(students);
        System.out.println("16b");
        stream16b
                .filter(s -> s.getScore() >= 56)
                .forEach(System.out::println);
//        System.out.println(Arrays.toString(students));

        System.out.println();
        System.out.println("17");
        StreamApi<Student> stream17 = new StreamApi<>(students);
        Double avgScore = stream17
                .filter(s -> s.getScore() >= 56)
                .map(Student::getScore)
                .avg();
        System.out.println(avgScore);

        System.out.println();
        System.out.println("18");
        StreamApi<Student> stream18 = new StreamApi<>(students);
        String longestLastName = stream18
                .filter(s -> s.getScore() >= 56)
                .map(Student::getLastName)
                .max(Comparator.comparingInt(String::length))
                .orElse("not found");
        System.out.println(longestLastName);
    }

    public static void init(Student[] students) {
        students[0] = new Student("Mark", "Potapov", 33);
        students[1] = new Student("Jake", "Hilton", 32);
        students[2] = new Student("Anna", "Ivanova", 85);
        students[3] = new Student("Alexander", "Sidorov", 17);
        students[4] = new Student("Olivia", "Smith", 13);
        students[5] = new Student("Sophia", "Brown", 65);
        students[6] = new Student("Liam", "Johnson", 90);
        students[7] = new Student("Emma", "Garcia", 44);
        students[8] = new Student("Noah", "Martinez", 88);
        students[9] = new Student("Isabella", "Lee", 56);
    }

}