package divideAndConquer;

/**
 * Created by ludao on 2017/5/4.
 */
public class ReverseStringII_541 {
    public String reverseStr(String s, int k) {
        if(s==null||s.length()==0||k<2){
            return s;
        }
        int length = s.length();
        if(length<k){
            return doReverse(s);
        }
        if(length<2*k){
            return doReverse(s.substring(0,k))+s.substring(k, length);
        }
        return doReverse(s.substring(0,k))+s.substring(k,2*k)+reverseStr(s.substring(2*k),k);
    }


    private String doReverse(String s){
        StringBuilder result = new StringBuilder(s);
        return result.reverse().toString();
    }
}
