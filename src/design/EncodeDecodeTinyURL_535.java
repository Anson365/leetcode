package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ludao on 2017/6/14.
 */
public class EncodeDecodeTinyURL_535 {
    private final String charList = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static List<String> list = new ArrayList();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        list.add(longUrl);
        return this.to62(list.size());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = from62(shortUrl);
        return list.get(index);
    }

    private String to62(long id) {
        StringBuffer str = new StringBuffer("");
        Stack s = new Stack();

        for(long num = id; num != 0L; num /= 62L) {
            s.push(Character.valueOf(charList.charAt((int) (num % 62L))));
        }

        while(!s.isEmpty()) {
            str.append(s.pop());
        }

        return str.toString();
    }

    private int from62(String url){
        int id = 0;
        for(char tempChar:url.toCharArray()){
            int temp = charList.indexOf(tempChar);
            id = id*62+temp;
        }
        return id;
    }
}
