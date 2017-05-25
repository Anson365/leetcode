package dp;

/**
 * Created by ludao on 2017/5/10.
 */
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if((t==null||t.length()==0)&&(s!=null&&s.length()!=0)){
            return false;
        }
        if(s==null||s.length()==0){
            return true;
        }
        int tPoint = 0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(tPoint)){
                tPoint++;
                if(tPoint==s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
