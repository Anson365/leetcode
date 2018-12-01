package dp;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/22/18.
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV_188 {
    public int maxProfit(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }
        if (k > prices.length / 2) {
            int buy = Integer.MIN_VALUE, sell = 0;
            for (int price : prices) {
                int tempSell = Math.max(sell, price - buy);
                buy = Math.max(buy, sell - price);
                sell = tempSell;
            }
            return sell;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = k - 1; j >= 1; j--) {
                sell[j] = Math.max(sell[j], buy[j] + price);
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
            }
            sell[0] = Math.max(sell[0], price + buy[0]);
            buy[0] = Math.max(-price, buy[0]);
        }
        return sell[k - 1];
    }


    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_IV_188 best_time_to_buy_and_sell_stock_iv_188
                = new Best_Time_to_Buy_and_Sell_Stock_IV_188();
        best_time_to_buy_and_sell_stock_iv_188.maxProfit(2, new int[]{6,1,3,2,4,7});
    }
}
