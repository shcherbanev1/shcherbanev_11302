import java.io.*;

import static java.lang.Thread.sleep;

public class DownloadManager {

    public static void download(Task task) {
        try (InputStream inputStream = new BufferedInputStream(task.getSource().openStream());
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(task.getPath() + getExtension(task.getSource().toString())))) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(dataBuffer, 0, dataBuffer.length)) != -1) {
                outputStream.write(dataBuffer, 0, bytesRead);
                task.setSize(bytesRead);
                // тестил статус
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // модификатор дефолт потому что нужен в рамках пакета метод
    static String getExtension(String url) {
        StringBuilder ans = new StringBuilder();
        for (int i = url.length() - 1; i >= 0; i--) {
            if (url.charAt(i) == '.') break;
            else ans.append(url.charAt(i));
        }
        return ans.append('.').reverse().toString();
    }

}
