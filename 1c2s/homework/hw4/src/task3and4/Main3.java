package task3and4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main3 {

    public static void main(String[] args) {

        HTMLParser parser = new HTMLParser();
        StringBuilder html = new StringBuilder();

        // считываем скачанный html в строку
        // я не скачивал т.к. скачать его можно также как и из task2
        // но с случайным сайтом может не прокататить
        // т.к. не все самозакрывающиеся теги добавлены
        // и я не делал обработку комментариев в html коде
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/html1.html"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                html.append(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения html");
        }

        try {
            DOMTree domTree = parser.parse(html.toString());
            System.out.println(domTree); // если сюда поставить дебагер то можно увидеть дерево
            domTree.writeTextBetweenTags("resources/text.txt");
        } catch (InvalidHTMLException e) {
            System.out.println("Введенный html содержит ошибку");
        }

    }

}
