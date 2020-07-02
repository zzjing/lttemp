
public class DuoStockTrader {
    // fundamental task: maximize Profit(i, k, s)
    // where i is a given day, k is the number of transactions allowed
    // and s is the current stock at hand, s = 0, 1 by problem statement
    // wish to know P(i, 2, 0), P(i, 2, 1) and P(i, 1, 0), P(i, 1, 1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // base cases: P(i, 1, 1) = P(i, 2, 1) = -infinity before trade dates
        // P(-1, 2, 0) = P(-1, 1, 0) = 0 before trade dates
        int soldStock2Prft = 0; // i, k = 2, s = 0
        int holdStock2Prft = Integer.MIN_VALUE; // i, k = 2, s = 1
        int soldStock1Prft = 0;
        int holdStock1Prft = Integer.MIN_VALUE;
        for (int price : prices) {
            // P(i, k, 0) = max[P(i - 1, k, 0), P(i - 1, k, 1) + price[i]
            soldStock2Prft = Math.max(soldStock2Prft, holdStock2Prft + price);
            holdStock2Prft = Math.max(holdStock2Prft, soldStock1Prft - price);
            soldStock1Prft = Math.max(soldStock1Prft, holdStock1Prft + price);
            holdStock1Prft = Math.max(holdStock1Prft, -price);
        }
        return soldStock2Prft;
    }
}
