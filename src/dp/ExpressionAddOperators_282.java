package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ludao on 2017/5/7.
 */
public class ExpressionAddOperators_282 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if(num == null||num.length()==0){
            return new ArrayList<String>(result);
        }
        helper(result,num,"",target,0,0,0);
        return result;
    }

    private void helper(List<String> list,String num,String path,int target,int index,long val,long preVal){
        if(index==num.length()){
            if(val==target){
                list.add(path);
            }
            return;
        }
        for(int i=index;i<num.length();i++){
            if(i!=index&&num.charAt(index)=='0') break;
            long curVal = Long.valueOf(num.substring(index,i+1));
            if(index==0){
                helper(list,num,curVal+"",target,i+1,curVal,curVal);
            }else {
                helper(list,num,new StringBuilder(path).append("+").append(curVal).toString(),target,i+1,val+curVal,curVal);
                helper(list,num,new StringBuilder(path).append("-").append(curVal).toString(),target,i+1,val-curVal,-curVal);
                helper(list,num,new StringBuilder(path).append("*").append(curVal).toString(),target,i+1,val-preVal+preVal*curVal,curVal*preVal);
            }
        }
    }


    public static void main(String[] args){
        String num = "105";
        int val = 5;
        ExpressionAddOperators_282 expressionAddOperators_282 = new ExpressionAddOperators_282();
        List<String> result = expressionAddOperators_282.addOperators(num,val);
        return;
    }


}
