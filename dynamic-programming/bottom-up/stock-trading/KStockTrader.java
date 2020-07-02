import java.util.Arrays;

public class KStockTrader {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length == 0) {
            return 0;
        }
        // exceeds critical number of transactions k -> infinity
        if (k >= (prices.length / 2)) {
            return infiniteTrade(prices);
        }
        int[] soldKthStock = new int[k + 1];
        int[] holdKthStock = new int[k + 1];
        Arrays.fill(holdKthStock, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                soldKthStock[j] = Math.max(soldKthStock[j], holdKthStock[j] + price);
                holdKthStock[j] = Math.max(holdKthStock[j], soldKthStock[j - 1] - price);
            }
        }
        return soldKthStock[k];
    }

    private int infiniteTrade(int[] prices) {
        int soldLast = 0;
        int holdLast = Integer.MIN_VALUE;
        for (int price : prices) {
            int soldPrev = soldLast;
            soldLast = Math.max(soldLast, holdLast + price);
            holdLast = Math.max(holdLast, soldPrev - price);
        }
        return soldLast;
    }
}
