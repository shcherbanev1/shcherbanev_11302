public class DownloadThread extends Thread {

    private final ExecutorService executorService;

    public DownloadThread(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void run() {
        while (true) {
            // если расскоментить то можно заметить что файлы качаются пачками по 8
            // т.к. сначала поток спит 10 сек потом берет файл.
            // как поток докачивает он берет новый файл и спит 10 сек
            // а в это время последний докачал - не знаю зачем это пишу
            // наверное это больше для меня - я лучше понимаю когда объясняю...
//            try {
//                sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            DownloadManager.download(executorService.getTask());
        }
    }
}
