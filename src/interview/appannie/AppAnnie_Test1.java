package interview.appannie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/12/18.
 */
public class AppAnnie_Test1 {
    public String solution(String S) {
        Map<String, String> map = buildMap();
        String[] files = S.split("\n");
        int musicSize = 0, imageSize = 0, movieSize = 0, otherSize = 0;
        for (String file : files) {
            String[] fileStrArray = file.split(" ");
            String fileName = fileStrArray[0];
            String tempSize = fileStrArray[1];
            int size = Integer.valueOf(tempSize.substring(0, tempSize.length() - 1));
            String tempType = fileName.substring(fileName.lastIndexOf(".") + 1);
            String type = map.getOrDefault(tempType, "other");

            switch (type) {
                case "music":
                    musicSize += size;
                    break;
                case "movie":
                    movieSize += size;
                    break;
                case "image":
                    imageSize += size;
                    break;
                default:
                    otherSize += size;
            }

        }
        StringBuilder result = new StringBuilder();
        result.append("music ").append(musicSize).append("b\n")
            .append("images ").append(imageSize).append("b\n")
            .append("movies ").append(movieSize).append("b\n")
            .append("other ").append(otherSize).append("b");

        return result.toString();

    }

    private Map<String, String> buildMap() {
        String music = "music", image = "image", movie = "movie", other = "other";
        Map<String, String> map = new HashMap<>();
        map.put("mp3", music);
        map.put("aac", music);
        map.put("flac", music);
        map.put("jpg", image);
        map.put("bmp", image);
        map.put("gif", image);
        map.put("mp4", movie);
        map.put("avi", movie);
        map.put("mkv", movie);
        map.put("7z", other);
        map.put("txt", other);
        map.put("zip", other);
        return map;
    }

//    public static void main(String[] args) {
//        AppAnnie_Test1 appAnnieTest1 = new AppAnnie_Test1();
//        appAnnieTest1.solution("my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b");
//    }
}
