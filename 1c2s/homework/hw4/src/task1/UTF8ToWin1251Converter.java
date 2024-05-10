package task1;

import java.io.*;

public class UTF8ToWin1251Converter extends Converter {

    public UTF8ToWin1251Converter(File input, File output) {
        super(input, output);
    }

    @Override
    public void convert() throws IOException {
        InputStream inputStream = new FileInputStream(input);
        OutputStream outputStream = new FileOutputStream(output);
        int first = inputStream.read();
        int second;
        while (first != -1) {
            if (first == 208) {
                second = inputStream.read();
                if (second == 129) {
                    outputStream.write(168);
                }
                else if (second >= 144 && second <= 191) outputStream.write(second + 48);
                else {
                    outputStream.write(first);
                    outputStream.write(second);
                }
            } else if (first == 209) {
                second = inputStream.read();
                if (second == 145) {
                    outputStream.write(184);
                }
                else if (second >= 128 && second <= 143) outputStream.write(second + 112);
                else {
                    outputStream.write(first);
                    outputStream.write(second);
                }
            } else {
                outputStream.write(first);
            }
            first = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
