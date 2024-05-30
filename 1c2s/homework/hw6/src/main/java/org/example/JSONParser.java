package org.example;

import java.util.*;

public class JSONParser {

    public static Map<String, Object> parseJson(String json) throws Exception {
        return parseObject(new JSONIterator(json));
    }

    private static Map<String, Object> parseObject(JSONIterator iterator) throws Exception {
        Map<String, Object> map = new HashMap<>();
        iterator.consume('{');
        while (iterator.peek() != '}') {
            String key = iterator.consumeString();
            iterator.consume(':');
            Object value = parseValue(iterator);
            if (value instanceof Map) {
                flattenMap((Map<String, Object>) value, map, key);
            } else {
                map.put(key, value);
            }
            if (iterator.peek() == ',') {
                iterator.consume(',');
            }
        }
        iterator.consume('}');
        return map;
    }

    private static List<Object> parseArray(JSONIterator iterator) throws Exception {
        List<Object> list = new ArrayList<>();
        iterator.consume('[');
        while (iterator.peek() != ']') {
            Object value = parseValue(iterator);
            list.add(value);
            if (iterator.peek() == ',') {
                iterator.consume(',');
            }
        }
        iterator.consume(']');
        return list;
    }

    private static Object parseValue(JSONIterator iterator) throws Exception {
        char c = iterator.peek();
        if (c == '"') {
            return iterator.consumeString();
        } else if (c == '{') {
            return parseObject(iterator);
        } else if (c == '[') {
            return parseArray(iterator);
        } else if (Character.isDigit(c) || c == '-') {
            return iterator.consumeNumber();
        } else if (c == 't' || c == 'f') {
            return iterator.consumeBoolean();
        } else if (c == 'n') {
            return iterator.consumeNull();
        } else {
            throw new Exception("Unexpected character: " + c);
        }
    }

    private static void flattenMap(Map<String, Object> nestedMap, Map<String, Object> mainMap, String parentKey) {
        for (Map.Entry<String, Object> entry : nestedMap.entrySet()) {
            String key = parentKey + "." + entry.getKey();
            mainMap.put(key, entry.getValue());
        }
    }
}