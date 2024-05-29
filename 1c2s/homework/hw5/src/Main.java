public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = new ExecutorService();
        CommandController commandController = new CommandController(executorService);
        ThreadInitializer.init(8, executorService);
        commandController.start();
    }
}

/* команды на потестить если понадобится
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music1
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music2
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music3
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music4
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music5
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music6
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music7
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music8
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music9
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music10
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music11
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music12
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music13
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music14
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music15
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music16
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music17
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music18
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music19
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music20
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music21
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music22
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music23
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music24
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music25
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music26
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music27
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music28
download https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3 C:\Users\shche\Downloads\shcherbanev\music29
*/