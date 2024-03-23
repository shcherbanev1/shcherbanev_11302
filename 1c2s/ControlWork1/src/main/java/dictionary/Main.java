package dictionary;

public class Main {

    public static void main(String[] args) throws InvalidLanguageException {
        Dictionary dict = new Dictionary("русско-английский");
        dict.insert("привет", "русско-английский", "hello");
        dict.insert("привет", "русско-английский", "hi");
        dict.insert("пока", "русско-английский", "bye");
        dict.insert("небо", "русско-английский", "sky");
        dict.insert("солнце", "русско-английский", "sun");
        dict.insert("птичка", "русско-английский", "bird");
        dict.insert("пока", "русско-английский", "bye-bye");
        dict.insert("жизнь", "русско-английский", "life");
        System.out.println(dict.unique());
        System.out.println();
        System.out.println(dict.numLen1());
        System.out.println();
        try {
            System.out.println(dict.translate("пока"));
        } catch (NoSuchTranslationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            System.out.println(dict.translate("подушка"));
        } catch (NoSuchTranslationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        dict.show();
        dict.delete("пока");
        System.out.println("УДАЛЯЕМ СЛОВО ПОКА");
        dict.show();
    }

}
