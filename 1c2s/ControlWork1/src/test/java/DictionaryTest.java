import dictionary.Dictionary;
import dictionary.InvalidLanguageException;
import dictionary.NoSuchTranslationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {

    private Dictionary dict;
    private final String lang = "русско-английский";


    @BeforeEach
    public void init() {
        dict = new Dictionary("русско-английский");
    }

    @Test
    public void testInsertToWrongDict() {
        assertThrows(InvalidLanguageException.class, () -> dict.insert("кошка", "русско-немецкий", "catze"));
    }

    @Test
    public void testTranslate() {
        try {
            dict.insert("привет", lang, "hi");
        } catch (InvalidLanguageException e) {
            System.out.println(e.getMessage());
        }
        try {
            assertEquals("Слово приветможно перевести c помощью русско-английский словаря так:\n" +
                    "hi", dict.translate("привет"));
        } catch (NoSuchTranslationException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testNumLen() {
        try {
            dict.insert("пока", lang, "bye");
            dict.insert("пока", lang, "bye-bye");
            dict.insert("небо", lang, "sky");
        } catch (InvalidLanguageException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, dict.numLen1());
    }

    @Test
    public void testUnique() {
        try {
            dict.insert("пока", lang, "bye");
            dict.insert("пока", lang, "bye-bye");
            dict.insert("привет", lang, "hi");
            dict.insert("привет", lang, "hello");
            dict.insert("небо", lang, "sky");
        } catch (InvalidLanguageException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(1, dict.unique().size());
    }

    @Test
    public void testDelete() {
        try {
            dict.insert("пока", lang, "bye");
            dict.insert("пока", lang, "bye-bye");
            dict.insert("привет", lang, "hi");
            dict.insert("привет", lang, "hello");
            dict.insert("небо", lang, "sky");
        } catch (InvalidLanguageException e) {
            System.out.println(e.getMessage());
        }
        dict.delete("привет");
        assertThrows(NoSuchTranslationException.class, () -> dict.translate("привет"));
    }

}
