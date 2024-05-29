import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Task {

    private final String path;

    private final URL source;

    private int totalSize;
    private int size;

    public Task(String path, String url) throws MalformedURLException {
        this.path = path;
        this.source = new URL(url);
        try {
            this.totalSize = source.openConnection().getContentLength();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getPath() {
        return path;
    }

    public URL getSource() {
        return source;
    }
    public int getTotalSize() {
        return totalSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
