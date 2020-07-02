
public class LongestMonotonicArray {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestMonotonicContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int streak = 1;
        int longest = 1;
        boolean increasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if ((increasing && (A[i] < A[i + 1])) || !increasing && (A[i] > A[i + 1])) {
                streak++;
                longest = Math.max(longest, streak);
            } else if ((!increasing && (A[i] < A[i + 1])) || (increasing && (A[i] > A[i + 1]))) {
                streak = 2;
                longest = Math.max(longest, streak);
                increasing = !increasing;
            } else {
                streak = 1;
            }
        }
        return longest;
    }
}
