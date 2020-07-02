
public class MaxPalindromeSubseqence {
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return longestPalindromeSubseq(s, 0, s.length() - 1, memo);
    }

    private int longestPalindromeSubseq(String s, int left, int right, int[][] memo) {
        if (left == right) {
            return 1;
        }
        if (left > right) {
            return 0;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        if (s.charAt(left) == s.charAt(right)) {
            memo[left][right] = 2 + longestPalindromeSubseq(s, left + 1, right - 1, memo);
        } else {
            memo[left][right] = Math.max(longestPalindromeSubseq(s, left + 1, right, memo),
                longestPalindromeSubseq(s, left, right - 1, memo));
        }
        return memo[left][right];
    }
}
