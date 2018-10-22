package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/22/18.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sellProfit = 0, buyProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            int buy = Math.max(buyProfit, sellProfit - price - fee);
            int sell = Math.max(sellProfit, buyProfit + price);
            sellProfit = sell;
            buyProfit = buy;
        }
        return Math.max(0, sellProfit);
    }
}
