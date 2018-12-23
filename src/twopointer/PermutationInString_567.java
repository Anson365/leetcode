package twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ludao on 2017/7/13.
 */
public class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length(),length2 = s2.length();
        if(length1>length2) return false;
        //s1 map
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(Character character:s1.toCharArray()){
            if(map.containsKey(character)){
                map.put(character,map.get(character)+1);
            }else {
                map.put(character,1);
            }
        }
        Map<Character,Integer> map2 = new HashMap<Character, Integer>();
        for(int i=0;i<length2;i++){
            Character tempChar = s2.charAt(i);
            if(i<length1){
                if(map2.containsKey(tempChar)){
                    map2.put(tempChar,map2.get(tempChar)+1);
                }else {
                    map2.put(tempChar,1);
                }
            }else {
                if(map2.containsKey(tempChar)){
                    map2.put(tempChar,map2.get(tempChar)+1);
                }else {
                    map2.put(tempChar,1);
                }
                Character removeChar = s2.charAt(i-length1);
                int freq = map2.get(removeChar);
                if(freq==1){
                    map2.remove(removeChar);
                }else {
                    map2.put(removeChar,freq-1);
                }
            }
            if(map.equals(map2)){
                return true;
            }
        }
        return false;
    }

//    public static void main(String[] args){
//        String s1 = "adc";
//        String s2 = "dcda";
//        PermutationInString_567 permutationInString_567 = new PermutationInString_567();
//        permutationInString_567.checkInclusion(s1,s2);
//
//    }
}
