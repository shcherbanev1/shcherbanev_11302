import java.net.MalformedURLException;

public class ExecutorService {

    private final MyConcurrentQueue<Task> queue;

    public ExecutorService() {
        queue = new MyConcurrentQueue<>();
    }

    public synchronized void addToQueue(Task task) throws MalformedURLException {
        queue.add(task);
        notifyAll();
    }

    public synchronized Task getTask() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return queue.poll();
    }

}
