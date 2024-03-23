package dictionary;

import java.io.IOException;

public class NoSuchTranslationException extends IOException {

    @Override
    public String getMessage() {
        return "Слово не найдено";
    }
}
