import java.util.Arrays;

public class PerfectSqrMinDecomp {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] perfectSqrs = new int[n + 1];
        Arrays.fill(perfectSqrs, Integer.MAX_VALUE);
        perfectSqrs[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minSqr = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                perfectSqrs[i] = Math.min(perfectSqrs[i], perfectSqrs[i - j * j] + 1);
                j++;
            }
        }   
        return perfectSqrs[n];
    }
}
