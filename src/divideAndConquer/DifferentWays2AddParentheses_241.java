package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/5/2.
 */
public class DifferentWays2AddParentheses_241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if(input==null||input.length()==0){
            return result;
        }
        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);
            if(temp=='+'||temp=='-'||temp=='*'){
                List<Integer> part1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for(Integer pre:part1){
                    for(Integer post:part2){
                        switch (temp){
                            case '+':{
                                result.add(pre+post);
                            }break;
                            case '-':{
                                result.add(pre-post);
                            }break;
                            case '*':{
                                result.add(pre*post);
                            }break;
                        }
                    }
                }
            }
        }
        if(result.size()==0){
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
