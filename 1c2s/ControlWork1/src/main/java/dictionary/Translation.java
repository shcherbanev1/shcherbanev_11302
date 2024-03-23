package dictionary;

public class Translation {

    private final String source;

    private final MyLinkedList<String> translations;

    public Translation(String source) {
        this.source = source;
        translations = new MyLinkedList<>();
    }
    public String getSource() {
        return source;
    }

    public void add(String translation) {
        translations.add(translation);
    }

    public MyLinkedList<String> getTranslations() {
        return translations;
    }

    @Override
    public String toString() {
        return source + " - " + translations;
    }
}
