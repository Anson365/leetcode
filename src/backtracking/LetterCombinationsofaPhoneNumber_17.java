package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ludao on 2017/7/10.
 */
public class LetterCombinationsofaPhoneNumber_17 {
    private String[] digintsArray = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        if(digits==null||digits.trim()==""){
            return result;
        }
        combination("",digits,0,result);
        return result;
    }

    private void combination(String prefix,String digits,int offest,List<String> result){
        if(offest>=digits.length()){
            result.add(prefix);
            return;
        }
        String letter = digintsArray[digits.charAt(offest)-'0'];
        for(int i=0;i<letter.length();i++){
            combination(prefix+letter.charAt(i),digits,offest,result);
        }
    }
}
