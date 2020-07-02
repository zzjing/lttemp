
public class SingleStockTrader {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxPrft = 0;
        int lowPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            lowPrice = Math.min(lowPrice, prices[i]);
            maxPrft = Math.max(maxPrft, prices[i] - lowPrice);
        }
        return maxPrft;
    }
}
