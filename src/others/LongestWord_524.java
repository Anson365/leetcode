package others;

import java.util.*;

/**
 * Created by ludao on 2017/4/7.
 */
public class LongestWord_524 {
    public String findLongestWord(String s, List<String> d) {
        if(s==null||s.length()==0||d==null||d.size()==0){
            return "";
        }
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) return o2.length()-o1.length();
                return o1.compareTo(o2);
            }
        });
        for(String dStr:d){
            if(isAllContain(s,dStr)){
                return dStr;
            }
        }
        return "";
    }
    private Boolean isAllContain(String source,String target){
        char[] characters = target.toCharArray();
        int start = -1;
        for(Character targetChar:characters){
            int index = source.indexOf(targetChar,start+1);
            if(index!=-1){
                start = index;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        LongestWord_524 longestWord_524 = new LongestWord_524();
        List<String> s = new ArrayList<String>();
//        s.add("ale");
//        s.add("apple");
//        s.add("monkey");
//        s.add("plea");
        s.add("aaa");
        s.add("aa");
        s.add("a");
        String result = longestWord_524.findLongestWord("aaa",s);
        System.out.println(result);
    }
}
