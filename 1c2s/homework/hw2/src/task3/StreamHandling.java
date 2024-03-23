import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamHandling {

    public static void main(String[] args) {
        List<Student> students = new LinkedList<>();
        students.add(new Student("Mark", "Potapov", 33));
        students.add(new Student("Jake", "Hilton", 32));
        students.add(new Student("Anna", "Ivanova", 85));
        students.add(new Student("Alexander", "Sidorov", 17));
        students.add(new Student("Olivia", "Smith", 13));
        students.add(new Student("Sophia", "Brown", 65));
        students.add(new Student("Liam", "Johnson", 90));
        students.add(new Student("Emma", "Garcia", 44));
        students.add(new Student("Noah", "Martinez", 88));
        students.add(new Student("Isabella", "Lee", 56));
        // 15
        printTask15a(students);
        System.out.println(getTask15a(students));
        // или если всех
        printTask15b(students);
        System.out.println(getTask15b(students));

        // 16
        double avgScore = students.stream()
                .filter(student -> student.getScore() >= 56)
                .mapToInt(Student::getScore)
                .average().orElse(-1);
        System.out.println(avgScore);

        // 18
        String longestLastName = students.stream()
                .filter(student -> student.getScore() >= 56)
                .map(Student::getLastName)
                .max(Comparator.comparingInt(String::length))
                .orElse("not found");
        System.out.println(longestLastName);
    }

    public static void printTask15a(List<Student> students) {
        students.stream()
                .filter(student -> student.getScore() >= 56)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static Student getTask15a(List<Student> students) {
        return students.stream()
                .filter(s -> s.getScore() >= 56)
                .findFirst().orElse(null);
    }

    public static void printTask15b(List<Student> students) {
        students.stream()
                .filter(student -> student.getScore() >= 56)
                .forEach(System.out::println);
    }

    public static List<Student> getTask15b(List<Student> students) {
        return students.stream()
                .filter(s -> s.getScore() >= 56)
                .collect(Collectors.toList());
    }

}
