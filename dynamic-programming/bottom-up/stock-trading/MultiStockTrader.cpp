class MultiStockTrader {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) {
            return 0;
        }
        int soldLast = 0;
        int holdLast = INT_MIN;
        for (int curPrice : prices) {
            int soldPrev = soldLast;
            soldLast = max(soldLast, holdLast + curPrice);
            holdLast = max(holdLast, soldPrev - curPrice);
        }
        return soldLast;
    }
};
