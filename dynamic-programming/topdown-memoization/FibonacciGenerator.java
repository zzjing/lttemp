
public class FibonacciGenerator {
    public int getFibonacciNum(int num) {
        return getFibonacciNum(num, new int[num + 1]);
    }
    
    private int getFibonacciNum(int num, int[] memo) {
        if (num == 0 || num == 1) {
            return num;
        }

        if (memo[num] == 0) {
            memo[num] = getFibonacciNum(num - 1, memo) + getFibonacciNum(num - 2, memo);
        }

        return memo[num];
    }
}
