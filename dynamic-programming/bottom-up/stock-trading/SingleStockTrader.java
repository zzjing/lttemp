
public class SingleStockTrader {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sold1Prft = 0;
        int hold1Prft = Integer.MIN_VALUE;
        for (int price : prices) {
            sold1Prft = Math.max(sold1Prft, hold1Prft + price);
            hold1Prft = Math.max(hold1Prft, -price);
        }
        return sold1Prft;
    }
}
