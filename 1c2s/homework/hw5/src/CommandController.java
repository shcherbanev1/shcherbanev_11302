import java.io.IOException;
import java.util.Scanner;
import java.net.MalformedURLException;

public class CommandController {
    private final ExecutorService executorService;

    public CommandController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            try {
                if (parts[0].equals("download")) {
                    if (parts.length == 3) {
                        String source = parts[1];
                        String path = parts[2];
                        Task task = new Task(path, source);
                        executorService.addToQueue(task);
                        TaskStorage.add(task);
                        System.out.println("Download task added");
                    } else {
                        System.out.println("Invalid command!\nUse: download <source_url> <destination_path>");
                    }
                } else if (parts[0].equals("status")) {
                    String path = parts[1];
                    try {
                        boolean isDownloaded = TaskStorage.getActualSize(path) == TaskStorage.getExpectedSize(path);
                        if (isDownloaded) System.out.println("100%");
                        else System.out.println("0%");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Unknown command! Available commands:" +
                            "\ndownload <source_url> <destination_path>" +
                            "\nstatus <destination_path>");
                }
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            }
        }
    }
}
