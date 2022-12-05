import java.util.ArrayList;

public class RuTubeVideoLoader implements VideoLoader{
    String url;
    ArrayList<String> videoList;

    public RuTubeVideoLoader() {
        videoList = new ArrayList<String>();
    }

    @Override
    public String load(String url) throws InterruptedException {


        if(videoList.indexOf(url) == -1){
            videoList.add(url);
        }
        System.out.println("Загрузка из сервера");
        Thread.sleep(500);
        return videoList.get(videoList.indexOf(url));
    }
}
