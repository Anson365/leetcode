package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/4/17.
 */
public class RemoveInvalidParentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if(s==null){
            return result;
        }
        char[] model = {'(',')'};
        remove(s,0,0,model,result);
        return result;
    }


    private void remove(String s,Integer m,Integer n,char[] model,List<String> result){
        for(int i=m,temp=0;i<s.length();i++){
            if(s.charAt(i)==model[0]) temp++;
            else if(s.charAt(i)==model[1]) temp--;
            else continue;
            if(temp>=0){
                continue;
            }
            for(int j=n;j<=i;j++) {
                if (s.charAt(j) == model[1] && (j == n || s.charAt(j - 1) != model[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, model, result);
                }
            }
            return;
        }
        String sReverse = new StringBuilder(s).reverse().toString();
        if(model[0]=='('){
            remove(sReverse,0,0,new char[]{')','('},result);
        }else {
            result.add(sReverse);
        }

    }

    public static void main(String[] args){
        String s = "(()(";
        RemoveInvalidParentheses_301 removeInvalidParentheses_301 = new RemoveInvalidParentheses_301();
        List<String> result = removeInvalidParentheses_301.removeInvalidParentheses(s);
        System.out.println(result);
    }
}
