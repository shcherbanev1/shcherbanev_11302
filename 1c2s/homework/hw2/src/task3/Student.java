public class Student {

    private final String firstName;
    private final String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + score;
    }

    private final int score;

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
