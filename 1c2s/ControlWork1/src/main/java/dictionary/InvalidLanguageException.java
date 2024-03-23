package dictionary;

import java.io.IOException;

public class InvalidLanguageException extends IOException {

    @Override
    public String getMessage() {
        return "Неправильный язык";
    }
}
