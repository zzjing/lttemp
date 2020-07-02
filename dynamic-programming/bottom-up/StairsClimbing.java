
public class StairsClimbing {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] climbWays = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            if (i == n || i == n - 1) {
                climbWays[i] = 1;
            } else {
                climbWays[i] = climbWays[i + 1] + climbWays[i + 2];
            }
        }
        return climbWays[0];
    }

    public int getWays(int n) {
        // base cases
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n <= 2) {
            return 2;
        }
        int oneBehind = 2;
        int twoBehind = 1;
        int climbWays = 0;
        for (int i = 3; i <= n; i++) {
            climbWays = oneBehind + twoBehind;
            twoBehind = oneBehind;
            oneBehind = climbWays;
        }
        return climbWays;
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length <= 1) {
            return 0;
        }  
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }
}
