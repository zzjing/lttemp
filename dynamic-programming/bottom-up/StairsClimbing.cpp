class StairsClimbing {
public:
    int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int oneBehind = 2;
        int twoBehind = 1;
        int climbWays = 0;
        for (int i = 2; i < n; i++) {
            climbWays = oneBehind + twoBehind;
            twoBehind = oneBehind;
            oneBehind = climbWays;
        }
        return climbWays;
    }

    int minCostClimbingStairs(vector<int>& cost) {
        if (cost.size() <= 1) {
            return 0;
        }
        for (int i = 2; i < cost.size(); i++) {
            cost[i] += min(cost[i - 1], cost[i - 2]);
        }
        return min(cost[cost.size() - 1], cost[cost.size() - 2]);
    }
};
