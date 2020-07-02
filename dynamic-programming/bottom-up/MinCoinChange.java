import java.util.Arrays;

public class MinCoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int maxOut = amount + 1;
        // minimum coins for given amount of face value
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, maxOut);
        minCoins[0] = 0; // initial condition
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // current face-value of a coin cannot exceed the total
                int coinVal = coins[j];
                if (coinVal <= i) { // + 1 -> because we need one more coin of coinVal
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coinVal] + 1);
                }
            }
        }
        if (minCoins[amount] > amount) {
            return -1;
        }
        return minCoins[amount];
    }
}
