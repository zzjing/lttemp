
public class StairClimber {
    public int climbCounter(int height) {
        return climbCounter(0, height, new int[height + 1]);
    }
    
    private int climbCounter(int stepLeft, int[] memo) {
        if (stepLeft <= 1) {
            return 1;
        }
        if (memo[stepLeft] != 0) {
            return memo[stepLeft];
        }
        memo[stepLeft] = climbCounter(stepLeft - 1, memo) + climbCounter(stepLeft - 2, memo);
        return memo[stepLeft];
    }

    // alternative climbing-up method
    /*
    private int climbCounter(int i, int height, int[] memo) {
        if (i > height) {
            return 0;
        }
        if (i == height) {
            return 1;
        }
        memo[i] = climbCounter(i + 1, height, memo) + climbCounter(i + 2, height, memo);
        return memo[i];
    }
    */
}
