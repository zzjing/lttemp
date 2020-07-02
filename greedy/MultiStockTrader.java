
public class MultiStockTrader {
    public int maxProfit(int[] prices) {
        int maxPrft = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // check if we should sell the current stock
            if (prices[i + 1] > prices[i]) {
                int profit = prices[i + 1] - prices[i];
                maxPrft += profit;
            }
        }
        return maxPrft;
    }
}
