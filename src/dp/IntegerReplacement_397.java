package dp;

/**
 * Created by ludao on 2017/4/26.
 */
public class IntegerReplacement_397 {
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else {
            if(n%2==0){
                return 1+integerReplacement(n/2);
            }else {
                return 1+Math.min(integerReplacement(n+1),integerReplacement(n-1));
            }
        }
    }

//    public static void main(String[] args){
//        IntegerReplacement_397 integerReplacement_397 = new IntegerReplacement_397();
//        int count = integerReplacement_397.integerReplacement(7);
//        return;
//    }
}
