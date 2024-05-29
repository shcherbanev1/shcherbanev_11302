public class ThreadInitializer {

    public static void init(int THREAD_NUMBER, ExecutorService executorService) {
        for (int i = 0 ; i < THREAD_NUMBER; i++) {
            DownloadThread downloadThread = new DownloadThread(executorService);
            downloadThread.start();
        }
    }

}
