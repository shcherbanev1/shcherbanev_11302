package task3and4;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


// Идея - использлвание стэка чтобы понять кто чей ребенок
// когда тэг закрылся то он уходит из стека
// пока не закрыт - сверху стека, но если есть ребенок то когда
// будем его обрабатывать он (ребенок) окажется сверху

// Идея со стеком взята с пар по АиСД)
public class HTMLParser {

    // Сет самозакрывающихся тегов
    private static final Set<String> SELF_CLOSABLE_TAGS = new HashSet<>();

    static {
        SELF_CLOSABLE_TAGS.add("meta");
        SELF_CLOSABLE_TAGS.add("link");
        SELF_CLOSABLE_TAGS.add("img");
        SELF_CLOSABLE_TAGS.add("!DOCTYPE");
    }


    public DOMTree parse(String html) throws InvalidHTMLException {

        Stack<Node> stack = new Stack<>();
        Node root = new Node("document");
        stack.push(root); // Так сказать родитель по умолчанию

        int i = 0;
        while (i < html.length()) {
            // Начало тега
            if (html.charAt(i) == '<') {
                int tagEnd = html.indexOf('>', i);
                if (tagEnd == -1) { // Если открылось и не закрылось то хтмл кривой
                    throw new InvalidHTMLException();
                }
                // Все что между < >
                String tagContent = html.substring(i + 1, tagEnd).trim();
                // Закрывающий тег
                if (tagContent.charAt(0) == '/') {
                    stack.pop();
                } else {
                    // Открывающий тег или самозакрывающийся тег
                    boolean selfClosing = SELF_CLOSABLE_TAGS.contains(getTagName(tagContent));
                    if (selfClosing) {
                        tagContent = tagContent.trim();
                    }

                    Node node = parseTagContentToNode(tagContent);
                    // Добавляем ребенка родителю
                    stack.peek().addChild(node);

                    if (!selfClosing) {
                        stack.push(node);
                    }
                }
                i = tagEnd;
            } else {
                // Текстовое содержимое
                int textEnd = html.indexOf('<', i);
                if (textEnd == -1) textEnd = html.length();
                String text = html.substring(i, textEnd).trim();
                if (!text.isEmpty()) {
                    stack.peek().setTextContent(stack.peek().getTextContent() + text);
                }
                i = textEnd - 1;
            }
            i++;
        }

        return new DOMTree(root);
    }

    private Node parseTagContentToNode(String tagContent) {
        String tagName = getTagName(tagContent);
        Node node = new Node(tagName);

        // Парсинг атрибутов
        // сначала отделили имя тега и часть с аттрибутами
        String[] parts = tagContent.split("\\s+", 2); // регулярка \\s+ это пробели их любое кол-во также таб
        if (parts.length > 1) { // если не только название тега есть
            String[] attrParts = parts[1].split("\" ");
            // т.к. у нас может содержать = в attrValue то сплит
            // по кавычке с пробелом
            // пример  - <meta name="viewport" content="width=device-width, initial-scale=1.0">
            // здесь равно есть у initial-scale хотя это значение для атрибута content
            for (int j = 0; j < attrParts.length; j++) {
                if (attrParts[j].contains("=")) {
                    String[] keyValue = attrParts[j].split("=", 2);
                    String attrName = keyValue[0].trim();
                    String attrValue = keyValue[1];
                    if (j != (attrParts.length - 1)) {
                        attrValue += "\""; // Добавляем кавычку т.к. мы сплители по кавычке с пробелом
                    }
                    node.addAttribute(attrName, attrValue);
                }
            }
        }
        return node;
    }

    private String getTagName(String tagContent) {
        return tagContent.split("\\s+", 2)[0];
    }

}
