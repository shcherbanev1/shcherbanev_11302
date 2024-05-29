import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TaskStorage {

   private static Map<String, URL> pathToUrlSource = new HashMap<>();

    public static void add(Task task) throws MalformedURLException {
        pathToUrlSource.put(task.getPath() + DownloadManager.getExtension(task.getSource().toString()), task.getSource());
    }

    public static int getExpectedSize(String path) throws IOException {
        if (pathToUrlSource.get(path) != null) return pathToUrlSource.get(path).openConnection().getContentLength();
        return -1;
    }

    public static long getActualSize(String path) {
        File file = new File(path);
        return file.length();
    }

}
