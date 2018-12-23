package hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ludao on 2017/6/16.
 */
public class BullsandCows_299 {
    public String getHint(String secret, String guess) {
        List<Character> aList = new ArrayList<Character>();
        List<Character> bList = new ArrayList<Character>();
        int aCount = 0,bCount = 0;

        for(int i=0;i<secret.length();i++){
            Character secretChar = secret.charAt(i);
            Character guessChar = guess.charAt(i);
            if(secretChar == guessChar){
                aCount++;
            }else {
                aList.add(secretChar);
                bList.add(guessChar);
                if(aList.contains(guessChar)){
                    bCount++;
                    aList.remove(guessChar);
                    bList.remove(guessChar);
                }
                if(bList.contains(secretChar)){
                    bCount++;
                    bList.remove(secretChar);
                    aList.remove(secretChar);
                }
            }
        }
        return aCount+"A"+bCount+"B";
    }

//    public static void main(String[] args){
//        String secret = "1807";
//        String guess = "7810";
//        BullsandCows_299 bullsandCows_299 = new BullsandCows_299();
//        String str = bullsandCows_299.getHint(secret, guess);
//        System.out.println(str);
//    }

}
