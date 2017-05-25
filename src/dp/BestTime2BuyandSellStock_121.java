package dp;

/**
 * Created by ludao on 2017/5/8.
 */
public class BestTime2BuyandSellStock_121 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int max= Math.max(prices[1] - prices[0],0),min = prices[0];
        for(int i=2;i<prices.length;i++){
            min = Math.min(prices[i-1],min);
            int temp = prices[i] - min;
            max = Math.max(temp, max);
        }
        return max;
    }
}
