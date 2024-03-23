package dictionary;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
    private Node<T> head;

    private Node<T> tail;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator<>(head);
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        Node<T> cur = head;
        while (cur != null) {
            ans.append(cur).append(", ");
            cur = cur.next;
        }
        ans.deleteCharAt(ans.length() - 1);
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }


    // где-то ОООЧЕНЬ хотелось использовать for each поэтому мне было проще создать итератор
    // а мы его как раз проходили
    private static class MyLinkedListIterator<T> implements Iterator<T> {

        private Node<T> current;

        public MyLinkedListIterator(Node<T> head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

}