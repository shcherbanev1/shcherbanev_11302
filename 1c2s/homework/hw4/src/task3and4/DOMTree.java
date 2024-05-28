package task3and4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DOMTree {

    private final Node root;

    public DOMTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public String toString() {
        return toStringNode(root);
    }

    private String toStringNode(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(node.getTagName());

        // Атрибуты
        for (Map.Entry<String, String> attribute : node.getAttributes().entrySet()) {
            sb.append(" ").append(attribute.getKey()).append("=").append(attribute.getValue());
        }

        sb.append(">");

        // Текст
        if (!node.getTextContent().isEmpty()) {
            sb.append(node.getTextContent());
        }

        // и рекурсивно для детей
        for (Node child : node.getChildren()) {
            sb.append(toStringNode(child));
        }

        sb.append("</").append(node.getTagName()).append(">");
        return sb.toString();
    }

    // Задание 29 (4ое из дз 4)
    public void writeTextBetweenTags(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(writeTextBetweenTagsNode(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String writeTextBetweenTagsNode(Node node) {
        StringBuilder sb = new StringBuilder();

        // Текст
        if (!node.getTextContent().isEmpty()) {
            sb.append(node.getTextContent());
            sb.append("\n");
        }
        // рекурсивно для детей
        for (Node child : node.getChildren()) {
            sb.append(writeTextBetweenTagsNode(child));
        }

        return sb.toString();
    }

}
