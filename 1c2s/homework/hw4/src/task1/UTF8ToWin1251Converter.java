package task1;

import java.io.*;

public class UTF8ToWin1251Converter extends Converter {

    // сдвинг для русский букв А-р
    private static final int SHIFT_FOR_LETTERS_А_п = 48;
    private static final int SHIFT_FOR_LETTERS_р_я = 112;
    private static final int А_CODE = 144;
    private static final int п_CODE = 191;
    private static final int р_CODE = 128;
    private static final int я_CODE = 143;

    public UTF8ToWin1251Converter(File input, File output) {
        super(input, output);
    }

    @Override
    public void convert() throws IOException {
        try (InputStream inputStream = new FileInputStream(input);
        OutputStream outputStream = new FileOutputStream(output)) {
            int first = inputStream.read();
            int second;
            while (first != -1) {
                if (first == 208) {
                    second = inputStream.read();
                    if (second == 129) { // Ё
                        outputStream.write(168);
                    }
                    else if (second >= А_CODE && second <= п_CODE) outputStream.write(second + SHIFT_FOR_LETTERS_А_п);
                    else {
                        outputStream.write(first);
                        outputStream.write(second);
                    }
                } else if (first == 209) {
                    second = inputStream.read();
                    if (second == 145) { // е
                        outputStream.write(184);
                    }
                    else if (second >= р_CODE && second <= я_CODE) outputStream.write(second + SHIFT_FOR_LETTERS_р_я);
                    else {
                        outputStream.write(first);
                        outputStream.write(second);
                    }
                } else {
                    outputStream.write(first);
                }
                first = inputStream.read();
            }
        }
    }
}
