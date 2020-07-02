class SingleStockTrader {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) {
            return 0;
        }
        int sold1Prft = 0;
        int hold1Prft = INT_MIN;
        for (int curPrice : prices) {
            sold1Prft = max(sold1Prft, hold1Prft + curPrice);
            hold1Prft = max(hold1Prft, -curPrice);
        }
        return sold1Prft;
    }
};
