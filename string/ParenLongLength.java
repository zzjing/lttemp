
public class ParenLongLength {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int leftCount = 0;
        int rightCount = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
                maxLen = Math.max(maxLen, leftCount * 2);
            } else if (rightCount > leftCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }
        leftCount = 0;
        rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                rightCount++;
            } else {
                leftCount++;
            }
            if (leftCount == rightCount) {
                maxLen = Math.max(maxLen, rightCount * 2);
            } else if (leftCount > rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }
        return maxLen;
    }
}
