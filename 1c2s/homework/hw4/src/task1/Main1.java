package task1;

import java.io.File;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args){
        Converter converter = new UTF8ToWin1251Converter(new File("resources/utf8.txt"), new File("resources/win1251.txt"));
        try {
            converter.convert();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}