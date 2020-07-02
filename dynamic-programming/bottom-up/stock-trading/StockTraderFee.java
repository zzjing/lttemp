
public class StockTraderFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int soldLast = 0;
        int holdLast = Integer.MIN_VALUE;
        for (int price : prices) {
            int soldPrev = soldLast;
            soldLast = Math.max(soldLast, holdLast + price); // note overflow
            holdLast = Math.max(holdLast, soldPrev - price - fee);
        }
        return soldLast;
    }
}
