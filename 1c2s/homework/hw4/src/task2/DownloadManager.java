package task2;

import java.io.*;
import java.net.URL;

public class DownloadManager {

    public static void download(URL url, String file) throws IOException {
        try (InputStream inputStream = new BufferedInputStream(url.openStream());
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("resources/" + file + getExtension(url.toString())))) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(dataBuffer, 0, dataBuffer.length)) != -1) {
                outputStream.write(dataBuffer, 0, bytesRead);
            }
        }
    }

    // получение расширения файла
    private static String getExtension(String url) {
        StringBuilder ans = new StringBuilder();
        for (int i = url.length() - 1; i >= 0; i--) {
            if (url.charAt(i) == '.') break;
            else ans.append(url.charAt(i));
        }
        return ans.append('.').reverse().toString();
    }

}
