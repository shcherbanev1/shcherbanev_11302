package task2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main2 {

    public static void main(String[] args) {
        try {
            DownloadManager.download(new URL("https://videocdn.cdnpk.net/harmony/content/video/partners1363/large_watermarked/BB_e68759c8-8cba-47d9-b856-7f97a649be03_FPpreview.mp4?filename=5205438_branch_sakura_bloom_3840x2160.mp4"), "video1");
            DownloadManager.download(new URL("https://res.allmacwallpaper.com/get/iMac-21-inch-5K-Retina-wallpapers/Moraine-Lake-Clouds-4096x2304/18712-13.jpg"), "photo1");
            DownloadManager.download(new URL("https://rus.hitmotop.com/get/music/20181102/Nervy_-_Tak_kak_nado_60079053.mp3"), "music1");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
