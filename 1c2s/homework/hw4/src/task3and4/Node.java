package task3and4;

import java.util.*;

public class Node {
    private final String tagName;
    private String textContent;
    private final List<Node> children;
    private final Map<String, String> attributes;

    public Node(String tagName) {
        this.tagName = tagName;
        this.textContent = "";
        this.children = new ArrayList<>();
        this.attributes = new HashMap<>();
    }

    public String getTagName() {
        return tagName;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void addAttribute(String name, String value) {
        this.attributes.put(name, value);
    }

}
