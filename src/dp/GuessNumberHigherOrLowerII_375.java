package dp;

/**
 * Created by ludao on 2017/5/11.
 */
public class GuessNumberHigherOrLowerII_375 {
    public int getMoneyAmount(int n) {
        int start = 1,end = n,sum=0,mid=0;
        while (start<end){
            mid = (end-start)/2 + start;
            sum += mid;
            start = mid+1;
        }
        return sum - mid;
    }
}
