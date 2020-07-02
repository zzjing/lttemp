
public class FencePainting {
    public int numWays(int n, int k) {
        if (n == 0 || k <= 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } // there are k ways of painting the first fence
        int diffColorCount = k * (k - 1);
        int sameColorCount = k * 1;
        for (int i = 2; i < n; i++) {
            int tmp = diffColorCount;
            // can paint a third fence of a different color regardless of the previous two
            diffColorCount = (diffColorCount + sameColorCount) * (k - 1);
            sameColorCount = tmp * 1; // cannot paint same color on three in a row
        }
        return (diffColorCount + sameColorCount);
    }
}
