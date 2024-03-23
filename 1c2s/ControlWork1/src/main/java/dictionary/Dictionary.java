package dictionary;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {

    private final String lang;
    private final MyLinkedList<Translation> dict = new MyLinkedList<>();

    public Dictionary(String lang) {
        this.lang = lang;
    }

    public void show() {
        for (Translation tr : dict) {
            System.out.println(tr);
        }
    }

    public void insert(String source, String lang, String new_translate) throws InvalidLanguageException {
        if (lang.equals(this.lang)) {
            boolean found = false;
            for (Translation tr : dict) {
                if (tr.getSource().equals(source)) {
                    tr.add(new_translate);
                    found = true;
                    break;
                }
            }
            if (!found) {
                    Translation o = new Translation(source);
                    o.add(new_translate);
                    dict.add(o);
            }
        } else {
            throw new InvalidLanguageException();
        }
    }

    public void delete(String k) {
        boolean deleted = false;
        Node<Translation> cur = dict.getHead();
        Node<Translation> prev = dict.getHead();
        while (cur != null && !deleted) {
            if (cur.value.getSource().equals(k)) {
                prev.next = cur.next;
                deleted = true;
                dict.size--;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public Set<String> unique() {
        Set<String> res = new HashSet<>();
        Node<Translation> cur = dict.getHead();
        while (cur != null) {
            if (cur.value.getTranslations().size == 1) {
                res.add(cur.value.getSource());
            }
            cur = cur.next;
        }
        return res;
    }

    public int numLen1() {
        int count = 0;
        Node<Translation> cur = dict.getHead();
        while (cur != null) {
            MyLinkedList<String> translations = cur.value.getTranslations();
            for (String tr : translations) {
                if (Math.abs(cur.value.getSource().length() - tr.length()) <= 1) {
                    count++;
                }
            }
            cur = cur.next;
        }
        return count;
    }

    public String translate(String text) throws NoSuchTranslationException {
        StringBuilder ans = new StringBuilder();
        for (Translation translation : dict) {
            if (text.equals(translation.getSource())) {
                for (String word : translation.getTranslations()) {
                    ans.append(word).append(", ");
                }
            }
        }
        if (ans.length() >= 2) {
            ans.deleteCharAt(ans.length() - 1);
            ans.deleteCharAt(ans.length() - 1);
        } else {
            throw new NoSuchTranslationException();
        }
        return "Слово " + text + "можно перевести c помощью " + lang + " словаря так:\n" + ans;
    }

}