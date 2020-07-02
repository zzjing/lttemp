class DuoStockTrader {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) {
            return 0;
        }
        int sold2Prft = 0;
        int hold2Prft = INT_MIN;
        int sold1Prft = 0;
        int hold1Prft = INT_MIN;
        for (int curPrice : prices) {
            sold2Prft = max(sold2Prft, hold2Prft + curPrice);
            hold2Prft = max(hold2Prft, sold1Prft - curPrice);
            sold1Prft = max(sold1Prft, hold1Prft + curPrice);
            hold1Prft = max(hold1Prft, -curPrice);
        }
        return sold2Prft;
    }
};
