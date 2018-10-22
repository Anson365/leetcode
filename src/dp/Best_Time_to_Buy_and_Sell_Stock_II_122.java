package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/22/18.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = 0 - prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfit_II(int[] prices) {
        int maxBuy = Integer.MIN_VALUE, maxSell = 0;
        for (int price : prices) {
            int buy = Math.max(maxBuy, maxSell - price);
            int sell = Math.max(maxSell, maxBuy + price);
            maxBuy = buy;
            maxSell = sell;
        }
        return maxSell;
    }
}
