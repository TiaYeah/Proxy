import java.util.ArrayList;
import java.util.List;

public class ProxyRuTubeVideoLoader implements VideoLoader{
    String url;
    RuTubeVideoLoader ruTubeVideoLoader;
    ArrayList<String> videoList;

    public ProxyRuTubeVideoLoader() {
        videoList = new ArrayList<String>();
        ruTubeVideoLoader = new RuTubeVideoLoader();

        videoList.add("www.rutube.ru/video1");
        videoList.add("www.rutube.ru/video2");
    }

    @Override
    public String load(String url) throws InterruptedException {
        if(videoList.indexOf(url) == -1) {
            videoList.add(ruTubeVideoLoader.load(url));
        }
        System.out.println("Загрузка из кэша");
        Thread.sleep(500);
        System.out.println("Видео загружено");
        return videoList.get(videoList.indexOf(url));
    }
}
