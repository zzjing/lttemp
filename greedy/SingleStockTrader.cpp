class SingleStockTrader {
public:
    int maxProfit(vector<int>& prices) {
        int maxPrft = 0;
        int minPrice = INT_MAX;
        for (int i = 0; i < prices.size(); i++) {
            maxPrft = max(maxPrft, prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }
        return maxPrft;
    }
};
