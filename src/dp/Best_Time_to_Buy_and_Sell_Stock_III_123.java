package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/22/18.
 */
public class Best_Time_to_Buy_and_Sell_Stock_III_123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy1 = Integer.MIN_VALUE,  buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(- price, buy1);
        }
        return Math.max(Math.max(0, sell1), sell2);
    }
}
