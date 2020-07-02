
public class MultiStockTrader {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
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
