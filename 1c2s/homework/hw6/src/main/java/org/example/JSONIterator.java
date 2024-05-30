package org.example;

public class JSONIterator {
    private final String json;
    private int pos;

    public JSONIterator(String json) {
        this.json = json;
    }

    public char peek() {
        while (json.charAt(pos) == ' ') {
            pos++;
        }
        return json.charAt(pos);
    }

    public void consume(char expected) throws Exception {
        if (peek() != expected) {
            throw new Exception("Expected '" + expected + "' but found '" + peek() + "'");
        }
        pos++;
    }

    public String consumeString() throws Exception {
        StringBuilder sb = new StringBuilder();
        consume('"');
        while (json.charAt(pos) != '"') {
            sb.append(json.charAt(pos));
            pos++;
        }
        consume('"');
        return sb.toString();
    }

    public Number consumeNumber() {
        int start = pos;
        if (json.charAt(pos) == '-') {
            pos++;
        }
        while (pos < json.length() && Character.isDigit(json.charAt(pos))) {
            pos++;
        }
        if (pos < json.length() && json.charAt(pos) == '.') {
            pos++;
            while (pos < json.length() && Character.isDigit(json.charAt(pos))) {
                pos++;
            }
            return Double.parseDouble(json.substring(start, pos));
        }
        return Integer.parseInt(json.substring(start, pos));
    }

    public Boolean consumeBoolean() throws Exception {
        if (json.startsWith("true", pos)) {
            pos += 4;
            return true;
        } else if (json.startsWith("false", pos)) {
            pos += 5;
            return false;
        } else {
            throw new Exception("Invalid boolean value");
        }
    }

    public Object consumeNull() throws Exception {
        if (json.startsWith("null", pos)) {
            pos += 4;
            return null;
        } else {
            throw new Exception("Invalid null value");
        }
    }
}