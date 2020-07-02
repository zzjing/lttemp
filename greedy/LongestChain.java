import java.util.Arrays;

public class LongestChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 ) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int longest = 1;
        int curChainEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > curChainEnd) {
                longest++;
                curChainEnd = pairs[i][1];
            }
        }
        return longest;
    }
}
