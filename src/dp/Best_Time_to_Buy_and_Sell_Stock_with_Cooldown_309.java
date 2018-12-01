package dp;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/1/18.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    public int maxProfit_I(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int[] buy = new int[length];
        int[] sell = new int[length];
        Arrays.fill(buy, Integer.MIN_VALUE);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        for (int i = 2; i < length; i++) {
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }
        return sell[length - 1];
    }


    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int buy_1 = -prices[0], buy_2 = Math.max(buy_1, - prices[1]);
        int sell_1 = 0, sell_2 = Math.max(sell_1, prices[1] + buy_1);
        int sell = sell_2, buy = buy_2;
        for (int i = 2; i < length; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell_1 - prices[i]);
            sell_1 = sell_2;
            sell_2 = sell;
        }
        return sell;
    }
}
