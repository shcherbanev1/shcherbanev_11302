package ru.itis;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int score;
    public static Student empty = new Student("not", "found", 0);

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + score;
    }

    public Student(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }
}

