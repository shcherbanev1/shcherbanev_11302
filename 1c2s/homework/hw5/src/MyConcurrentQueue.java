import java.util.LinkedList;
import java.util.Queue;

public class MyConcurrentQueue<T> {
    private final Queue<T> queue;

    public MyConcurrentQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void add(T value) {
        queue.add(value);
    }

    public synchronized T poll() {
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

}