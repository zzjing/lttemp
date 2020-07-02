
public class CoinStack {
    public int arrangeCoins(int n) {
        // need to find the floor of the solution to the equation
        // x * (1 + x) / 2 = n
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }
}
